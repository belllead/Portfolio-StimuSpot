package com.ssafy.pjt.api.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.api.user.service.UserService;
import com.ssafy.pjt.model.dto.UserDto;
import com.ssafy.pjt.util.ErrorHandler;
import com.ssafy.pjt.util.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "유저 컨트롤러")
@RequestMapping("/user-api")
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	UserService service;
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@ApiOperation(value= "로그인", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto user, HttpSession session){
		UserDto temp = service.login(user.getUserId(), user.getUserPw());
		
		Map<String, Object> result = new HashMap<String,Object>();
		HttpStatus status = null;
		
		try {
			if(temp != null) {
				result.put("access-token", jwtUtil.createToken("id",temp.getUserId()));
				result.put("message", SUCCESS);
				result.put("userNum",temp.getUserNum());
				status = HttpStatus.ACCEPTED;
			}else {
				result.put("message", FAIL);
				status = HttpStatus.NOT_ACCEPTABLE;
			}
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
		return new ResponseEntity<Map<String, Object>>(result,status);
	}
	
	@ApiOperation(value= "회원가입", response = String.class)
	@PostMapping("/regist")
	public ResponseEntity<?> signup(UserDto user){
		try {
			if(service.signup(user)) return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NOT_ACCEPTABLE);
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "로그아웃", response = Void.class)
	@GetMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}	
	
	@ApiOperation(value= "num으로 유저 정보 조회", response = UserDto.class)
	@GetMapping("/")
	public ResponseEntity<?> getUserInfo(@RequestParam(required = true) int userNum){
		UserDto user = service.searchByNum(userNum);
		try {
			if(user != null ) return new ResponseEntity<UserDto>(user,HttpStatus.OK);
			
			else return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "사용자 정보 수정", response = String.class)
	@PutMapping("/")
	public ResponseEntity<?> updateUserInfo(UserDto user){
		try {
			if(service.modifyUser(user)) return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NOT_ACCEPTABLE);
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "접속 기록 조회", response = UserDto.class)
	@GetMapping("/log")
	public ResponseEntity<?> getLoginLog(@RequestParam(required = true) int userNum){
		String log = service.getLog(userNum);
		try {
			if(log != null) return new ResponseEntity<String>(log,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);			
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
}
