package com.ssafy.pjt.api.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pjt.model.dao.UserDao;
import com.ssafy.pjt.model.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	@Override
	public boolean signup(UserDto user) {
		return userDao.insertUser(user) > 0;
	}

	@Override
	public UserDto login(String userId, String userPw) {
		UserDto temp = userDao.selectById(userId);
		if(temp != null && temp.getUserPw().equals(userPw)) {
//			userDao.insertLog(temp.getUserNum());
			return temp;
		}
		return null;
	}

	@Override
	public UserDto searchByNum(int userNum) {
		return userDao.selectByNum(userNum);
	}
	
	@Transactional
	@Override
	public boolean modifyUser(UserDto user) {
		return userDao.modifyUser(user) > 0;
	}

	@Override
	public String getLog(int userNum) {
		return userDao.getLog(userNum);
	}
}
