package com.example.boardstudy.config;

import com.example.boardstudy.intercepter.LoginIntercepter;
import com.example.boardstudy.intercepter.LogoutIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                .addPathPatterns("/board/write")
                .addPathPatterns("/board/doWrite")
                .addPathPatterns("/board/modify")
                .addPathPatterns("/board/doModify")
                .addPathPatterns("/board/doDelete")
                .addPathPatterns("/member/myPage")
                .addPathPatterns("/member/doModify")
                .addPathPatterns("/member/logout")
                .addPathPatterns("/reaction/insertReaction")
                .addPathPatterns("/reaction/deleteReaction");

        registry.addInterceptor(new LogoutIntercepter())
                .addPathPatterns("/member/login")
                .addPathPatterns("/member/doLogin")
                .addPathPatterns("/member/join")
                .addPathPatterns("/member/doJoin");
    }
}
