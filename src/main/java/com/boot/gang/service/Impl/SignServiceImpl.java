package com.boot.gang.service.Impl;

import com.boot.gang.entity.IntegralDetail;
import com.boot.gang.entity.Sign;
import com.boot.gang.entity.User;
import com.boot.gang.mapper.IntegralDetailMapper;
import com.boot.gang.mapper.SignMapper;
import com.boot.gang.mapper.UserMapper;
import com.boot.gang.service.SignService;
import com.boot.gang.util.DateUtil;
import com.boot.gang.util.GoldGZ;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-01-14 14:46
 **/
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SignMapper signMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    IntegralDetailMapper integralDetailMapper;
    @Override
    @Transactional
    public Sign sign(String userId) throws Exception{

        List<Sign>  signs = signMapper.selectByUserId(userId);
        Sign sign = null;
        if (signs.size() == 0){
            sign = new Sign(userId, 1, new Date());
            sign.setDouDay(1);
            signMapper.insertSelective(sign);
            User user = userMapper.selectByPrimaryKey(userId);
            if (user.getcGoldGz() == null) {
                user.setcGoldGz(0);
            }
            Integer goldGz_changed = user.getcGoldGz() + 2;
            user.setcGoldGz(goldGz_changed);
            userMapper.updateByPrimaryKeySelective(user);
            // 添加钢豆变化明细
            IntegralDetail integralDetail =  new IntegralDetail("GD" +System.nanoTime(), 2.0, 1, new Date(), goldGz_changed.doubleValue(), "", user.getcRealname(), userId, "用户签到", 1);
            integralDetailMapper.insertSelective(integralDetail);

        }else {
            sign = signs.get(0);

            String today = DateUtil.getFormateDay(new Date());      //今天
            String lastSignTime = DateUtil.getFormateDay(sign.getLastSignTime());   // 上次签到时间
            // 是否当天, 当天就是已签到,不可再签到
            if (!today.equals(lastSignTime)) {
                int dou = 0;
                // 判断昨天签没签到
                if (ifBreakSign(sign.getLastSignTime())) {
                    // 获得钢豆的天数
                    sign.setDouDay(sign.getDouDay() + 1);
                    if (sign.getDouDay() > 7) {
                        sign.setDouDay(1);
                    }
                    // 连续签到天数
                    sign.setCntDays(sign.getCntDays() + 1);
                    sign.setLastSignTime(new Date());
                    dou = GoldGZ.valueOf("DAY" + sign.getDouDay()).getDou();
                } else { // 只要昨天没有签到,两个计数器均置1
                    sign.setCntDays(1);
                    sign.setDouDay(1);
                    dou = 2;
                    sign.setLastSignTime(new Date());
                }
                signMapper.updateByPrimaryKey(sign);
                User user = userMapper.selectByPrimaryKey(userId);
                Integer goldGz_changed = user.getcGoldGz() + dou;
                user.setcGoldGz(goldGz_changed);
                userMapper.updateByPrimaryKeySelective(user);
                // 添加钢豆变化明细
                IntegralDetail integralDetail =  new IntegralDetail("GD" +System.nanoTime(), Double.parseDouble(dou +""), 1, new Date(), goldGz_changed.doubleValue(), "", user.getcRealname(), userId, "用户签到", 1);
                integralDetailMapper.insertSelective(integralDetail);
            }
        }
        return sign;
    }
    // 判断天数是否连续
    private boolean ifBreakSign(Date date){
        String today = DateUtil.getFormateDay(new Date());
        String yesterday = DateUtil.getFormateDay(new Date(DateUtil.getDate(today, "yyyy-MM-dd").getTime() - 24 * 3600 * 1000));
        String lastSignTime = DateUtil.getFormateDay(date);
        if (yesterday.equals(lastSignTime)) {
            return true;
        }
        return false;
    }
}
