package com.atguigu.crowdfunding.dao;

import com.atguigu.crowdfunding.bean.Member;
public interface MemberMapper {
 int selectCountOfMember(Member member);
 void insertMember(Member member);
	
}
