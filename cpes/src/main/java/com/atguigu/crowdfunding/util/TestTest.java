package com.atguigu.crowdfunding.util;

import org.apache.poi.ss.formula.functions.Sumif;
import org.junit.Test;

public class TestTest {
    
	@Test
	public void use() {
		// 计算任意整数从自身加到1的和
		int caculateSum = TestTest.CaculateSum(5);
		System.out.println(caculateSum);
		
		
	}

	 // 3
	static int sum = 0;
	public static int CaculateSum(int num) {
		sum += num + (--num);
		while(--num>0){
			CaculateSum(num);
		}
		return sum;
	}

}
