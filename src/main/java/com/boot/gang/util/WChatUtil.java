package com.boot.gang.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: lingang
 * @description: 微信工具类
 * @author: dongxiangwei
 * @create: 2020-01-17 15:22
 **/
public class WChatUtil {
        /**
         * 微信登录
         *
         * @param code
         * @param redirectUrl 返回用户的登录地址
         * @param request
         * @param response
         * @param model
         * @return
         * @throws java.io.IOException
         */
        @RequestMapping(value = "/weixinLogin.jspx")
        public String weixinLogin(String code, String redirectUrl, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
            String redirect_uri = "/weixinLogin.jspx";
            //获取code

            String[] s = getOpenId(code);
            String openId = s[0];
            String accessToken = s[1];
            String[] userInfo = getUserInfo(openId, accessToken);//获取用户信息
            System.out.println("手机登录openId=================================>" + openId);
//            User user = UserMng.findByUsername(openId); //查询用户是否存在，openId 作为查询条件
            String equipment = (String) request.getAttribute("ua");
           return "";

        }


        /**
         * 获取用户授权 得到openId,accessToken
         *
         * @param code
         * @return
         */
        public String[] getOpenId(String code) {
            String appid = "";
            String secret = "";
            appid = "公众号的APP_ID";
            secret = "公众号的APP_SECRET";
            String tokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code";
            tokenUrl = tokenUrl + "&appid=" + appid + "&secret=" + secret + "&code=" + code;
            JSONObject json = null;
            try {
                json = new JSONObject((Map<String, Object>) HttpClientUtil.getInstance().get(tokenUrl));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String openId = "";
            String accessToken = "";
            String[] s = new String[2];
            if (json != null) {
                try {
                    openId = json.getString("openid");
                    accessToken = json.getString("access_token");
                    s[0] = openId;
                    s[1] = accessToken;
                } catch (JSONException e) {
                    String errcode = null;
                    try {
                        errcode = json.getString("errcode");
                        System.out.println("errcode================>手机登录 获取用户授权失败" + errcode);
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            return s;
        }


        /**
         * 获取用户信息 拉取用户信息(需scope为 snsapi_userinfo)
         * 只有在用户将公众号绑定到微信开放平台帐号后，可以获取unionid
         *
         * @param
         * @param
         * @return
         */
        public String[] getUserInfo(String openid, String accessToken) {
            String tokenUrl = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN";
            tokenUrl = tokenUrl + "&access_token=" + accessToken + "&openid=" + openid;
            JSONObject json = null;
            try {
                json = new JSONObject((Map<String, Object>) HttpClientUtil.getInstance().get(tokenUrl));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String nickname = ""; //用户昵称
            String sex = "";  //用户的性别
            String province = ""; //用户个人资料填写的省份
            String city = "";  //普通用户个人资料填写的城市
            String country = ""; //国家，如中国为CN
            String headimgurl = ""; //用户头像，
            String unionid = ""; //
            String[] s = new String[8];
            if (json != null) {
                try {
                    nickname = json.getString("nickname");
                    sex = json.getString("sex");
                    province = json.getString("province");
                    city = json.getString("city");
                    country = json.getString("country");
                    headimgurl = json.getString("headimgurl");
                    s[0] = nickname;
                    s[1] = sex;
                    s[2] = province;
                    s[3] = city;
                    s[4] = country;
                    s[5] = headimgurl;
                } catch (JSONException e) {
                    String errcode = null;
                    try {
                        errcode = json.getString("errcode");
                        System.out.println("errcode================>获取用户信息失败" + errcode);
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            return s;
        }

        /**
         * 获取code请求地址
         *
         * @param redirect_uri  回调地址
         * @param
         * @return
         */
        public String getCodeUrl(String redirect_uri) {
            String codeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize";
            String appid = "公众号的APP_ID";
            codeUrl = codeUrl + "?appid=" + appid + "&redirect_uri=" + redirect_uri
                    + "&response_type=code&scope=snsapi_userinfo&state=jetcms#wechat_redirect";

            return codeUrl;
        }

}
