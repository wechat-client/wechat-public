package com.wechat.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.app.pojo.App;
import com.wechat.app.service.IAppService;
import com.wechat.common.utils.ConnectWechatUtil;
import com.wechat.menu.pojo.TokenPojo;
import com.wechat.user.pojo.User;
import com.wechat.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name="userService")
	private IUserService userService;
	
	@Resource(name="appService")
	private IAppService appService;
	
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		User loginUser = userService.userLogin(user);
		if(loginUser!=null) {
			if(loginUser.getUserType().equals("2")){
				return "frontviews/portal";
			}else{
				request.getSession().setAttribute("User", loginUser);
				List<App> apps = appService.getUserApps(loginUser.getUserId());
				if(apps.size()>0){
					TokenPojo tp = ConnectWechatUtil.getAccessToken(apps.get(0).getAppKey(), apps.get(0).getAppSecret());
					request.getSession().setAttribute("accessToken", tp.getToken());
					return "main";
				}
				return "no-app";
			}
		}
		return "redirect:/commons/error";
	}
	
	@RequestMapping("/weportal")
	public String portalView(User user,HttpServletRequest request){
		
		return "frontviews/portal";
			
	}
}

