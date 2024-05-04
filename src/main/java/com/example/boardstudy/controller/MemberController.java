package com.example.boardstudy.controller;

import com.example.boardstudy.dto.MemberDTO;
import com.example.boardstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/member/doJoin")
    @ResponseBody
    public String doJoin(@RequestParam("loginId") String loginId, @RequestParam("loginPw") String loginPw,
                         @RequestParam("name") String name, @RequestParam("nickname") String nickname,
                         @RequestParam("tel") String tel, @RequestParam("email") String email,
                         @RequestParam("address") String address){

        memberService.doJoin(loginId, loginPw, name, nickname, tel, email, address);

        return "ㅎㅇㅎ";
    }

    @GetMapping("/member/test")
    public String test(Model model){
        MemberDTO member = memberService.test(1);

        model.addAttribute("member", member);

        return "/member/list";
    }

}
