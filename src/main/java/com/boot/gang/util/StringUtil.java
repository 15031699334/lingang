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
    public static final String REGEX_MOBILE = "(^[1][3,4,5,7,8][0-9]{9}$)";
//    public static final String REGEX_IDCARD = "(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$)";
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


    /**
     * 判断字符串对象是否是null或者空
     * @param obj
     * @return
     */
    public static boolean isNullOrEmpty(String obj) {
        return obj == null || "".equals(obj.toString().trim());
    }

    /**
     * 如果是null返回空
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if (obj == null)
            return "";
        return obj.toString();
    }

    /**
     * 首字母转换为大写
     * @param str
     * @return
     */
    public static String firstCharUpper(String str)
    {
        if (isNullOrEmpty(str)) {
            return "";
        }
        return str.substring(0, 1).toUpperCase()+str.substring(1);
    }

}
