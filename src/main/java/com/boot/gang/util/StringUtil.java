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
