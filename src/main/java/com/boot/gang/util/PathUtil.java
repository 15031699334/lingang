package com.boot.gang.util;

import org.springframework.stereotype.Component;

/**
 * @ClassName: lingang
 * @description: 路径公用工具类
 * @author: dongxiangwei
 * @create: 2019-12-30 17:39
 **/
@Component
public class PathUtil {

    public static String PATH_PC = "D:/Program Files/Nginx 1.16/nginx-1.16.1/html";
    public static String PATH_PHONE = "D:/Program Files/Nginx 1.16/nginx-1.16.1/html/phone";

    // 静态资源文件上传路径
    public static String SERVER_WEB = "http://lg.zheok.com/";

    public  static String PATH_UPLOAD_LICENSE = "upload/license";
    public  static String PATH_UPLOAD_HEAD_LOGO = "upload/head";
    public  static String PATH_UPLOAD_CHAT = "upload/chat";


}
