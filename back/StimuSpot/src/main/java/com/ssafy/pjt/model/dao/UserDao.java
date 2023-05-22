package com.ssafy.pjt.model.dao;

import com.ssafy.pjt.model.dto.UserDto;

public interface UserDao {
	
	// id로 사용자 정보 조회
	public UserDto selectById(String id);
	
	// 사용자 등록
	public int insertUser(UserDto user);
	
	// 로그인 기록
	public int insertLog(int num);
}
