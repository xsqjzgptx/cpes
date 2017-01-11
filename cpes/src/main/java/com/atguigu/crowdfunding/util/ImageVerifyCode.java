package com.atguigu.crowdfunding.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

public class ImageVerifyCode {

	private Font mFont = new Font("Times New Roman", Font.BOLD, 24);
	
	@RequestMapping("/verify")
	public void webverify( HttpServletResponse response, Integer r1, HttpSession session ) throws Exception {
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		
		response.setContentType("image/png");
		
		int width  = 100;
		int height = 40;
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = image.getGraphics();
		
//		String color = p.getColorstyle();
		String	color = "#59B0FF";
		if ( StringUtil.isNotEmpty(color) ) {
			g.setColor(new Color(Integer.parseInt(color.substring(1, 3), 16),Integer.parseInt(color.substring(3, 5), 16),Integer.parseInt(color.substring(5, 7), 16)));	
		} else {
			g.setColor(new Color(50,118,177));
		}
		
		g.fillRect(1, 1, width-1, height-1);
		//66D178
		//g.setColor(new Color(204,204,204));
		g.setColor(new Color(77,170,255));
		g.drawRect(0, 0, width-1, height-1);
		g.setFont(mFont);
		g.setColor(new Color(255,255,255));
		
		String content = "";
		int i = r1;
		
		int i1 = new Random().nextInt(10);
		
		content = i + " + " + i1 + " = ? ";
		
		g.drawString(content, 10, 25);
		session.setAttribute("authcode", ""+(i+i1));
		g.dispose();
		ImageIO.write(image, "PNG", response.getOutputStream());
	}
	
	
}
