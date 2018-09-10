package com.lin.controller;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by lys on 2018/9/5.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class HelloController {
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

	@RequestMapping("/foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

}
