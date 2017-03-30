package com.my.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.model.User;
import com.my.service.IUserService;

import org.apache.log4j.Logger;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件
	@Resource
	IUserService userService;

	@RequestMapping(value = "/list")

	public String list(@RequestParam(value = "name", required = false) String name, ModelMap model) {

		Map<String, Object> map = new HashMap<String, Object>();

		if (name != null && name != "") {
			map.put("name", "%" + name + "%");
		}

		List list = userService.getList(map);

		model.addAttribute("list", list);
		
		log.info("/user/list");

		return "/user/list";
	}

	@RequestMapping(value = "/detail")
	public String detail(String id, ModelMap model) {

		User user = userService.getByUserId(id);
		model.addAttribute("model", user);

		return "/user/detail";
	}

	@RequestMapping(value = "/add")
	public String add() {

		return "/user/add";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (user.getName() == "") {
			result.put("code", -1);
			result.put("msg", "姓名不能为空");

			return result;
		}

		int id = userService.insert(user);

		result.put("code", 1);
		result.put("msg", "成功");

		return result;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public Map<String, Object> delete(int id) {
		Map<String, Object> result = new HashMap<String, Object>();

		if (userService.deleteByPrimaryKey(id) > 0) {
			result.put("code", 1);
			result.put("msg", "成功");
			return result;
		}

		result.put("code", -1);
		result.put("msg", "删除失败");

		return result;
	}
}
