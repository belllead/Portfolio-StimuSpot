package com.ssafy.pjt.api.user.service;

import com.ssafy.pjt.model.dto.UserDto;

public interface UserService {
	
	public boolean signup(UserDto user);
	
	public UserDto login(String id, String password);
}
