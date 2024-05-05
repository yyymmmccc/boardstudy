package com.example.boardstudy.controller;

import com.example.boardstudy.vo.Member;
import com.example.boardstudy.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor // final이 붙은놈 빈 객체를 컨테이너가 관리
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/join")
    public String join(){

        return "/member/join";
    }

    @PostMapping("/member/doJoin")
    @ResponseBody
    public String doJoin(Member member){

        memberService.doJoin(member);

        return "/home/main";
    }

    @GetMapping("/member/login")
    public String login(){

        return "/member/login";
    }

    @PostMapping("/member/doLogin")
    public String doLogin(HttpSession session, @RequestParam(value="loginId") String loginId, @RequestParam(value="loginPw") String loginPw){
        Member member = memberService.getMember(loginId);

        if(member == null){
            return "아이디를 확인해주세요.";
        }
        if(!member.getLoginPw().equals(loginPw)){
            return "비밀번호가 일치하지않습니다.";
        }

        session.setAttribute("member", member);

        return "/home/main";
    }

    @GetMapping("/member/myPage")
    public String myPage(HttpSession session, Model model){
        
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("member", member);

        return "/member/myPage";
    }

    @GetMapping("/member/doModify")
    public String doModify(Member member){

        System.out.println(member.toString());
        memberService.doModify(member);

        return "/home/main";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession httpSession){

        httpSession.removeAttribute("member");
        return "/home/main";
    }

}
