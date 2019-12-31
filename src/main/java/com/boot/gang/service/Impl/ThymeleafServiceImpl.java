package com.boot.gang.service.Impl;

import com.boot.gang.entity.Article;
import com.boot.gang.mapper.ArticleMapper;
import com.boot.gang.service.ThymeleafService;
import com.boot.gang.util.PathUtil;
import com.boot.gang.util.ThymeleafUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sun.dc.path.PathException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ThymeleafServiceImpl implements ThymeleafService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ThymeleafUtil thymeleafUtil;
    @Autowired
    PathUtil pathUtil;
    @Autowired
    ArticleMapper articleMapper;


    /**
     * 创建html页面
     *
     * @param pageName
     * @throws Exception
     */
    @Override
    public void createHtml(String pageName, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
        // 页面所需参数
        Map<String, Object> map = new HashMap<>();
        switch (pageName){
//            case "id":
//                map.put("name","姓名");
//                map.put("age","10岁");
//                map.put("email","邮箱");
//                // 首次请求时 返回页面的参数
////                request.setAttribute("obj", map);
//                model.addAttribute(map);
//                break; //可选
            /*       *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-      PC端页面           *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-   */
            case "header":      // 头
                break;
            case "footer":      // 底
                break;
            case "index":   // 首页
                logger.info("走到了 shop");
                break;
            case "shop":    // 商城(临钢优选)
                logger.info("走到了 shop");
                break;
            case "enjoy":    // 临钢智享
                logger.info("走到了 enjoy");
                break;
            case "information":     // 钢板资讯
                logger.info("走到了 information");
                List<Article> list = articleMapper.getAllNews();
                request.setAttribute("news", list);
                map.put("news", list);
                break;
            case "help":    // 会员中心
                logger.info("走到了 help");
                break;
            case "guanjia":     // 专属服务
                logger.info("走到了 guanjia");
                break;
            case "team-index":  // 走进临钢
                logger.info("走到了 team-index");
                break;
            case "team-dynamic":    // 临钢动态
                logger.info("走到了 team-dynamic");
                break;
            case "team-join":       // 招贤纳士
                logger.info("走到了 team-join");
                break;
            case "team-find":       // 联系我们
                logger.info("走到了 team-find");
                break;
            case "user-person":       // 账户信息
                logger.info("走到了 user-person");
                break;
            case "user-order":       // 我的订单
                logger.info("走到了 user-order");
                break;
            case "user-payfor":       // 付款记录
                logger.info("走到了 user-order");
                break;
            /*   *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*        手机端 页面         -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-    */
            case "phone/phone":
                logger.info("走到了 phone/phone");
                break;
            default:      // 所有的都没有走到 自动走进此项之中
                logger.info("service 参数获取错误");
                throw new PathException("页面不存在");
        }
        thymeleafUtil.createHtml(pageName, request, map);
    }


    @Override
    public void deleteHtml(String fileName) {
        try {
            thymeleafUtil.deleteHtml(fileName);
            System.out.println("已删除静态文件：" + fileName);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
