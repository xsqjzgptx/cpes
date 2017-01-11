package com.atguigu.crowdfunding.service.i;

import com.atguigu.crowdfunding.bean.Member;

public interface MemberService {

	String regist(Member member);

	String login(Member member);

}
