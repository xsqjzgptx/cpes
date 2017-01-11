package com.atguigu.crowdfunding.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.bean.Member;
import com.atguigu.crowdfunding.service.i.MemberService;
import com.atguigu.crowdfunding.dao.MemberMapper;
import com.atguigu.crowdfunding.util.MD5Util;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired()
	private MemberMapper memberMapper;

	@Override
	public String regist(Member member) {
		member.setUserpswd(MD5Util.digest(member.getUserpswd())); 
		int count = memberMapper.selectCountOfMember(member);
		if (count>0) {
			return "该用户名已存在,请重新注册!";
		}else {
			memberMapper.insertMember(member);
			return "注册成功";
		}
	}

	@Override
	public String login(Member member) {
		member.setUserpswd(MD5Util.digest(member.getUserpswd())); 
		int count=0;
		try {
			count = memberMapper.selectCountOfMember(member);
		} catch (Exception e) {
			System.out.println(e.getMessage()+"===="+e.getCause());
			e.printStackTrace();
		}
		System.out.println(count+"----");
		if (count==0) {
			return "该账号不存在,请重新输入!";
		}else {
			return "登陆成功!";
		}
	}

}
