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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.model.Page;
import com.my.model.User;
import com.my.service.IUserService;

import org.apache.log4j.Logger;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件
	@Resource
	IUserService userService;

	@RequestMapping(value = "/list")
	public String list(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			ModelMap model) {

		Map<String, Object> map = new HashMap<String, Object>();

		if (name != null && name != "") {
			map.put("name", "%" + name + "%");
		}

		PageHelper.startPage(page, 10);
		List list = userService.getList(map);
		
		PageInfo pageInfo = new PageInfo(list);

		model.addAttribute("list", list);
		model.addAttribute("pageInfo",pageInfo);

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
		
		if (user.getName() == "") {
			return EndError("姓名不能为空");
		}

		int id = userService.insert(user);
		
		return EndSuccess();
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public Map<String, Object> delete(int id) {

		if (userService.deleteByPrimaryKey(id) > 0) {
			return EndSuccess();
		}

		return EndError("删除失败");
	}
	
}
