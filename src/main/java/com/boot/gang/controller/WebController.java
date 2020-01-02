package com.boot.gang.controller;

import com.boot.gang.service.ThymeleafService;
import com.boot.gang.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    ThymeleafService thymeleafService;


    /**
     * redis 测试
     */
    @GetMapping("/test1")
    @ResponseBody
    public void test1(){
        // 保存字符串
        // 普通
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        // 封装好之后的
        redisUtil.set("bbb", "value");
        System.out.println(redisUtil.hasKey("bbb"));
        System.out.println(redisUtil.get("aaa"));

    }

    /**
     *  thymeleaf 以html结尾的请求 结合nginx实现静态化
     * @param pageName     xxx
     * @param request
     * @param response
     */
//    @ResponseBody
    @GetMapping(value = "{pageName}.html")
    public String pageCreate(@PathVariable String pageName, HttpServletRequest request, HttpServletResponse response, Model model){

        System.out.println("html 生成 走了controller: " + pageName);
        try {
            thymeleafService.createHtml(pageName, request, response, model);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return pageName;
    }

   /**
    * @Description
    * @param pageName
    * @param request
    * @param response
    * @param model
    * @return java.lang.String
    * @Author dongxiangwei
    * @Date 15:12 2019/12/31
    **/
//    @ResponseBody
    @GetMapping(value = "phone/{pageName}.html")
    public String phonePageCreate(@PathVariable String pageName, HttpServletRequest request, HttpServletResponse response, Model model){

        System.out.println("phone 端 html 生成 走了controller: phone/" + pageName);
        try {
            thymeleafService.createHtml("phone/"+ pageName, request, response, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "phone/" + pageName;
    }



}
