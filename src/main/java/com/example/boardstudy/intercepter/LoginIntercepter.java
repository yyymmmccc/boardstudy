package com.example.boardstudy.intercepter;

import com.example.boardstudy.util.Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginIntercepter implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception{

        HttpSession session = request.getSession();

        if(session.getAttribute("member") == null){
            Util.responseHistoryBack("로그인 후 이용해주세요.", response);
            return false;
        }

        return true;
    }
}
