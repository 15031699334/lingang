package com.boot.gang.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName: lingang
 * @description: 消息工具
 * @author: dongxiangwei
 * @create: 2020-01-03 15:37
 **/
@Component
public class MsgUtil {
    private String SUCCESS = "1";
    private String ERROR = "0";
    public JSONObject jsonSuccessMsg(String msg, Map map){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", SUCCESS);
        jsonObject.put("msg", msg);
        jsonObject.putAll(map);
        return jsonObject;
    }
    public JSONObject jsonSuccessMsg(String msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", SUCCESS);
        jsonObject.put("msg", msg);
        return jsonObject;
    }
    public JSONObject jsonSuccessMsg(String msg, String key, String value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", SUCCESS);
        jsonObject.put("msg", msg);
        jsonObject.put(key, value);
        return jsonObject;
    }
    public JSONObject jsonErrorMsg(String msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ERROR);
        jsonObject.put("msg", msg);
        return jsonObject;
    }


}
