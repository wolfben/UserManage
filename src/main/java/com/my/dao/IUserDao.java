package com.my.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.model.User;

@Repository  
public interface IUserDao {

	User getByUserId(String id);
	
	List<User> getList(Map<String,Object> map);
	
	int insert(User user);
	
	int deleteByPrimaryKey(Integer id);
}
