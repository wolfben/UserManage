package com.my.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my.model.User;

@Repository  
public interface IUserDao {

	User getByUserId(String id);
	
	List<User> getList();
	
	int insert(User user);
	
	int deleteByPrimaryKey(Integer id);
}
