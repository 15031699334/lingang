package com.boot.gang.service.Impl;

import com.boot.gang.entity.VolumePriceTrend;
import com.boot.gang.mapper.VolumePriceTrendMapper;
import com.boot.gang.service.VolumePriceTrendService;
import com.boot.gang.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-12-03 16:50
 **/
@Service
public class VolumePriceTrendServiceImpl implements VolumePriceTrendService {

    @Autowired
    private VolumePriceTrendMapper volumePriceTrendMapper;

    @Override
    public Map<String, List> getVolumePriceTrend(HttpServletRequest request) {

        String vpt_type_num = request.getParameter("vpt_type_num"); //  1=唐山地区 2=莱芜地区 3=邯郸地区 4=天津地区
        Assert.notNull(vpt_type_num, "参数未获取到");

        Map<String, List> map = new HashMap<>();
        List list = new ArrayList();
        List<String> vptTypeNames = volumePriceTrendMapper.getVptTypeName(vpt_type_num);
        vptTypeNames.forEach(vptTypeName -> {
            Map<String, Object> map1 = new HashMap<>();
            List<VolumePriceTrend> vpts = volumePriceTrendMapper.getList(" and vpt_type_num = '" + vpt_type_num + "' and vpt_type_name = '" + vptTypeName + "' order by vpt_time desc limit 7");
            List<String> jjgl_date = new ArrayList<>();
            List<Double> jjgl_ld = new ArrayList<>();
            // 数据赋值
            for (int i = 6; i > -1; i --) {
//                String day = DateUtil.getDateFormat(DateUtil.addDay(new Date(), -i), "MM-dd");
                String day = DateUtil.getDateFormat(vpts.get(i).getVptTime(), "MM-dd");
                jjgl_date.add(day);
                option(vpts, jjgl_ld, i, day);
            }
            map.put("jjgl_date", jjgl_date);
            map1.put("name", vptTypeName);
            map1.put("data", jjgl_ld);
            list.add(map1);

        });
        map.put("value", list);
        map.put("vptTypeNames", vptTypeNames);
        return map;
    }

    private void option(List<VolumePriceTrend> list, List<Double> ld, int index, String day) {

        for (VolumePriceTrend volumePriceTrend: list){
            if (DateUtil.getDateFormat(volumePriceTrend.getVptTime(), "MM-dd").equals(day)){
                ld.add(volumePriceTrend.getVptPrice());
            }
        }
        if (ld.size() < 7 - index){
            ld.add(list.get(index).getVptPrice());
        }
    }
}
