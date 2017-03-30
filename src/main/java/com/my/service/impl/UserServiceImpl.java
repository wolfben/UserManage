package com.my.service.impl;

import org.springframework.stereotype.Service;
import com.my.dao.IUserDao;
import com.my.model.User;
import com.my.service.IUserService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	IUserDao userDao;

	@Override
	public User getByUserId(String id) {
		// TODO Auto-generated method stub

		return userDao.getByUserId(id);
	}

	@Override
	public List<User> getList(Map<String,Object>map) {
		return userDao.getList(map);
	}

	@Override
	public int insert(User user){
		return userDao.insert(user);
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id){
		return userDao.deleteByPrimaryKey(id);
	}
}
