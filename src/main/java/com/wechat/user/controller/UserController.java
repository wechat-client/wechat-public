package com.wechat.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.user.pojo.User;
import com.wechat.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name="userService")
	private IUserService userService;
	
	
	@RequestMapping("/login")
	public String login(User user){
		
		if(userService.userLogin(user)) {
			
			return "main";
		}
		
		return "redirect:/commons/error";
		
	}
	
}
