package com.atguigu.crowdfunding.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.User;
import com.atguigu.crowdfunding.cpes.service.i.RoleService;
import com.atguigu.crowdfunding.cpes.service.i.UserService;
import com.atguigu.crowdfunding.helper.GlobalMessage;
import com.atguigu.crowdfunding.util.MD5Util;
import com.atguigu.crowdfunding.util.StringUtil;

@Controller
@RequestMapping("/system/user")
public class UserController {
	
	@Autowired
	private UserService userService ;
	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping("/assignRole")
	private Object asginRole(Datas datas ,@RequestParam("id") Integer userid){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			userService.asignRole(datas,userid);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "分配角色信息失败");
		}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/unAssignRole")
	private Object unAssignRole(Datas datas , @RequestParam("id")Integer userid){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			userService.unAssignRole(datas,userid);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "取消分配角色失败");
		}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/assignAll")
	private Object asignAll(@RequestParam("id")Integer userid){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			userService.asignAll(userid);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "批量分配角色失败");
		}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/unAssignAll")
	private Object unAssignAll(@RequestParam("id")Integer userid){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			userService.unAssignAll(userid);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "批量取消分配角色失败");
		}
		return resultMap;
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/role/{userid}")
	private String role(@PathVariable("userid")Integer userid,Map<String,Object>map){
		//查出所有的角色  以及当前用户有的角色  把这两个集合都返回页面  在页面上判断是否包含进而实现选中效果
		//页面还需要当前user的对象
		User user = userService.getUserById(userid);
		List<Role> roles = roleService.getAll();
		List<Integer> asignedRoleIdList = userService.getAsignedRolesByUid(userid);
		map.put("user", user);
		map.put("rs", roles);
		map.put("ars", asignedRoleIdList);
		return "user/role";
	}
	
	
	
	@ResponseBody
	@RequestMapping("/deletes")
	public Object delete(Datas datas){
		System.out.println(datas.getUsers());
		List<User> users = datas.getUsers();
		for (User user : users) {
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			userService.delete(datas);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "删除用户信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/add")
	public String add(){
		return "user/add";
	}
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(User user){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			userService.insert(user);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "新增用户信息失败");
		}
		return resultMap;
	}
	
	
	@RequestMapping("/edit/{userid}")
	public String edit(@PathVariable("userid")Integer userid,Map<String,Object>map){
		User user = userService.getUserById(userid);
		map.put("user", user);
		return "user/edit";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Object update(User user){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			userService.update(user);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("error", "修改用户信息失败");
		}
		return resultMap;
		
	}
	
	
	@RequestMapping("/index")
	public String index(){
		return "user/index";
	}
	@ResponseBody
	@RequestMapping("/datas")
	public Object toIndex(Integer draw, Integer start,
			@RequestParam(value = "length") Integer pagesize) {
		Map<String, Object> paraMetersMap = new HashMap<String, Object>();
		// paraMetersMap.put("draw", draw) ;
		paraMetersMap.put("start", start);
		paraMetersMap.put("pageSize", pagesize);
		Page<User> page = userService.getAllUsers(paraMetersMap);
		page.setDraw(draw); // 传过来 再传回去
		return page;
	}
	
	
	@ResponseBody
	@RequestMapping("/login")
	public Map<String,Object> login(User user,
			@RequestParam("authcode")String authcode,
			HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		//先验证验证码
		String authCode2 = (String) session.getAttribute(GlobalMessage.AUTH_CODE);
		if (authCode2==null || !authCode2.equals(authcode)) {
			map.put("success", false);
			map.put("error", GlobalMessage.AUTH_CODE_ERROR);
		}else {
			User loginUser = userService.getUserByName(user.getLoginacct());
			if (loginUser ==null) {
				map.put("success", false);
				map.put("error", GlobalMessage.LOGIN_ERROR);
			}else {
				if (loginUser.getUserpswd().equals(MD5Util.digest(user.getUserpswd()))) {
					map.put("success", true);
					session.setAttribute(GlobalMessage.LOGIN_USER, loginUser);
				}else {
					map.put("success", false);
					map.put("error", GlobalMessage.UNAMEORPWD_OOTEXIST);
				}
			}
		}
		
		return map;
	}
	
	
//private Font mFont = new Font("Times New Roman", Font.BOLD, 24);
	
	@RequestMapping("/verify")
	public void webverify( HttpServletResponse response, 
			@RequestParam("r")Integer r1, HttpSession session
			) throws Exception {
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
//		g.setFont(mFont);
		g.setColor(new Color(255,255,255));
		
		String content = "";
		int i = r1;  // 1
		
		int i1 = new Random().nextInt(10);
		
		content = i + " + " + i1 + " = ? ";
		
		g.drawString(content, 10, 25);
		session.setAttribute(GlobalMessage.AUTH_CODE, ""+(i+i1));//答案放在session中以供使用
		g.dispose();
		ImageIO.write(image, "PNG", response.getOutputStream());
		
	}
	
	
	
	
	
}
