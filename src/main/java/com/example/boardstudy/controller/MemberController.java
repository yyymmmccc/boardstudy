package com.example.boardstudy.controller;

import com.example.boardstudy.util.Util;
import com.example.boardstudy.vo.Member;
import com.example.boardstudy.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/join")
    public String join(){

        return "/member/join";
    }

    @PostMapping("/member/doJoin")
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
        Member member = memberService.getMemberByLoginId(loginId);

        if(member == null){
            return Util.historyBackMsg("회원정보가 일치하지않습니다.");
        }

        if(!member.getLoginPw().equals(loginPw)) {
            return Util.historyBackMsg("회원정보가 일치하지않습니다.");
        }

        session.setAttribute("member", member);

        return "/home/main";
    }

    @GetMapping("/member/myPage")
    public String myPage(HttpSession session, Model model){
        // 처음 로그인 했을 때의 member 세션정보를 받아와서 해당 loginId로 DB에서 새롭게 받아옴 (회원정보수정을 했을 수 있으니)
        Member member = (Member) session.getAttribute("member");

        member = memberService.getMemberByLoginId(member.getLoginId());

        model.addAttribute("member", member);

        return "/member/myPage";
    }

    @GetMapping("/member/doModify")
    public String doModify(Member member){

        memberService.doModify(member);

        return "/home/main";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession httpSession){

        httpSession.removeAttribute("member");
        return "/home/main";
    }

}
