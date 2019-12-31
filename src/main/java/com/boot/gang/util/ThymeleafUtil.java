package com.boot.gang.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

@Component
public class ThymeleafUtil {

    @Autowired
    private TemplateEngine templateEngine;//这是thymeleaf模板处理引擎
    @Autowired
    StringUtil stringUtil;
    private String path = "D:/Program Files/Nginx 1.16/nginx-1.16.1/html"; //这是工程中的配置属性，如静态文件的根目录/usr/local/nginx/html
    /**
     * @Description //TODO 在指定目录下生成静态页方法
     * @Param [pageName 页面名 例: index  或者 phone/index,
     *          request,
     *          map 传入页面的参数]
     * @return void
     * @Author dongxiangwei
     * @Date 18:10 2019/12/30
     **/
    public void createHtml(String pageName, HttpServletRequest request, Map map) throws Exception{
        String fileName = request.getRequestURI();
        if(!fileName.endsWith(".html")) {//将.html结尾的请求生成静态页面
            throw new Exception("页面不是以 .html结尾");
        }
        // 上下文
        Context context = new Context();
        // 页面参数
        context.setVariables(map);

        // 输出流
//        if (pageName.contains("/")){  // 判断是否含有/   有:true
//            path = path.concat("/" + pageName.substring(0, pageName.indexOf("/")));
//            pageName = stringUtil.splitEndByDiagonal(pageName);
//        }

        File dest = new File(path, pageName + ".html");
        if (dest.exists()) {
            dest.delete();
        }
        PrintWriter writer = new PrintWriter(dest, "UTF-8");
        // 生成html，第一个参数是thymeleaf页面下的路径+文件名     配合application.properties 的thymeleaf.prefix 和thymeleaf.suffix 产生作用
        templateEngine.process(pageName, context, writer);
        writer.close();
    }

    /**
     * @Description //TODO 删除静态页方法
     * @Param [fileName]
     * @return void
     * @Author dongxiangwei
     * @Date 11:12 2019/12/28
     **/
    public void deleteHtml(String fileName) {
        try {
            fileName = path + fileName;
            File file = new File(fileName);
            //删除文件或目录
            file.delete();
            System.out.println("已删除静态文件：" + fileName);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
