package com.boot.gang.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.boot.gang.entity.User;
import com.boot.gang.service.TokenService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getcId())
                .sign(Algorithm.HMAC256(user.getcPassword()));
        return token;
    }

    @Override
    public String getIdByToken(HttpServletRequest request) throws Exception{
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        if (token == null) {
            throw new Exception("token == null");
        }else {
            return JWT.decode(token).getAudience().get(0);
        }
    }
}
