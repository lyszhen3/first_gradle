package com.lin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lin.data.entity.User;
import com.lin.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lys on 2018/10/1.
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
@Controller
public class JpaTestTestController {
	private UserRepository userRepository;
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/user")
	@ResponseBody
	public String testUser(){
		List<User> all = userRepository.findAll();
		return JSONObject.toJSONString(all);
	}
	@RequestMapping("/addUser")
	@ResponseBody
	public  JSON  insertOne(){
		User user = new User();
		user.setName("wode tian ");
		user.setTestType(3);
		userRepository.save(user);
		userRepository.flush();
		return JSON.parseObject("{\"status\":\"ok\",\"id\":"+user.getTestId()+"}");
	}

}
