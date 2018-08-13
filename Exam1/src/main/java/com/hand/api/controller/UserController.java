package com.hand.api.controller;

import com.github.pagehelper.PageInfo;
import com.hand.api.dto.Page;
import com.hand.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String login(@RequestBody Map<String,Object> map){
		int res = userService.confirm(map);
		if(res == 1){
			return "登陆成功！";
		}
		return "登录失败！";
	}

	@PutMapping("/{id}")
	public Map<String,Object> update(@PathVariable("id")int id, @RequestBody Map<String,Object> map) {
		return userService.update(id,map);
	}


	@PutMapping("/")
	public Map<String,Object> create(@RequestBody Map<String,Object> map) {
		Map<String,Object> map1 = userService.create(map);
		if(map1 == null){
			map1 = new HashMap<>();
			map1.put("code",0);
			map1.put("error","地址不存在");
		}
		return map1;
	}

	@DeleteMapping("")
	public String delete(@CookieValue int id) {
		int res = userService.delete(id);
		if(res > 0){
			return "delete success";
		}
		return "delete error";
	}

	@GetMapping("/")
	public PageInfo<Map<String, Object>> list(Page page) {
		PageInfo<Map<String, Object>> mapList = userService.listFilm(page);
		return mapList;
	}
}
