package com.my.service;

import java.util.List;

import com.my.model.User;

public interface IUserService {
	User getByUserId(String id);
	
	List<User> getList();
	
	int insert(User user);
	
	int deleteByPrimaryKey(Integer id);
}
