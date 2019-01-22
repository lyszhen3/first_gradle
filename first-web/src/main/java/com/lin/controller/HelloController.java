package com.lin.controller;

import com.alibaba.fastjson.JSONObject;
import com.lin.data.entity.User;
import com.lin.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lys on 2018/9/5.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class HelloController {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/")
	@PreAuthorize("hasAnyRole('ROLE_US')")
	public String home(Model model, Authentication authentication) {
		model.addAttribute("message", "Hello World");
		model.addAttribute("title", "Hello Home");
		model.addAttribute("date", new Date());
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			System.out.println(authority.getAuthority());
		}
		return "home";
	}

	/**
	 * 测试 service send event
	 * 服务端给前端发数据
	 * @return
	 * @throws InterruptedException
	 */
	@ResponseBody
	@RequestMapping(value = "/testSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE+";charset=UTF-8")
	public String testSSE() throws InterruptedException {
		List<User> all = userRepository.findAll();
		String s = JSONObject.toJSONString(all);
		return "data:"+new Date().toString()+"::"+s +"\n\n";
	}

	@RequestMapping("/foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

}
