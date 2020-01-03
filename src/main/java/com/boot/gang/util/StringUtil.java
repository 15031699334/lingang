package com.boot.gang.util;

import org.springframework.stereotype.Component;

/**
 * @ClassName: lingang
 * @description: String 工具类
 * @author: dongxiangwei
 * @create: 2019-12-30 18:23
 **/
@Component
public class StringUtil {

    // 手机号验证正则
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
    public static final String  REGEX_PASSWORD = "(^[a-zA-Z0-9_-]{6,16}$)";

    /**
     * @Description //TODO 传入的字符串 通过/进行截取
     * @Param [str]
     * @return  有斜线 返回斜线后面的字符串   无返回本身
     * @Author dongxiangwei
     * @Date 18:30 2019/12/30
     **/
    public static String splitEndByDiagonal(String str){

        return str.contains("/")? str.substring(str.lastIndexOf("/")+1): str;
    }


}
