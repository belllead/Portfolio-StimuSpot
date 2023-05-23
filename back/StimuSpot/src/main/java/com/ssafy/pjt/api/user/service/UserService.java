package com.ssafy.pjt.api.user.service;

import com.ssafy.pjt.model.dto.UserDto;

public interface UserService {
	
	public boolean signup(UserDto user);
	
	public UserDto login(String userId, String userPw);
	
	public UserDto searchByNum(int userNum);
	
	public boolean modifyUser(UserDto user);
	
	public String getLog(int userNum);
}
