package com.ssafy.pjt.model.dao;

import com.ssafy.pjt.model.dto.UserDto;

public interface UserDao {
	
	// id로 사용자 정보 조회
	public UserDto selectById(String userId);
	
	// num로 사용자 정보 조회
	public UserDto selectByNum(int userNum);
	
	// 사용자 등록
	public int insertUser(UserDto user);
	
	// 사용자 정보 수정
	public int modifyUser(UserDto user);
	
	// 로그인 기록 등록
	public int insertLog(int userNum);
	
	// 마지막 로그인 기록 조회
	public String getLog(int userNum);
}
