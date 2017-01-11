package com.atguigu.crowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowdfunding.bean.Member;
import com.atguigu.crowdfunding.helper.GlobalMessage;
import com.atguigu.crowdfunding.service.i.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService ;
	
	@RequestMapping("/index")
	private String index(){
		return "member/index";
	}
	
	
	@ResponseBody
	@RequestMapping("/reg")
    private Object registMember(Member member){
		Map<String, Object> map = new HashMap<String, Object>();
		String registMsg  = "";
		try {
		    registMsg  = memberService.regist(member);
			map.put("success", true);
		} catch (Exception e) {
			map.put("error", registMsg);
		}
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/login")
    private Object login(Member member,HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		String loginMsg = "登陆出错了";
		try {
			
//			Member loginMember = loginMsg  = memberService.login(member);
//			map.put("success", true);
//			session.setAttribute(GlobalMessage.LOGIN_MEMBER, value);
		} catch (Exception e) {
			map.put("error", loginMsg);
		}
		return map;
    }
	
	
}
