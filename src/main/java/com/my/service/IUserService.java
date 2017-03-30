package com.my.service;

import java.util.List;
import java.util.Map;

import com.my.model.User;

public interface IUserService {
	User getByUserId(String id);
	
	List<User> getList(Map<String,Object>map);
	
	int insert(User user);
	
	int deleteByPrimaryKey(Integer id);
}
