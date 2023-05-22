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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<?> login(UserDto user, HttpSession session){
		UserDto temp = service.login(user.getUserId(), user.getUserPw());
		
		Map<String, Object> result = new HashMap<String,Object>();
		HttpStatus status = null;
		
		try {
			if(temp != null) {
				result.put("access-token", jwtUtil.createToken("id",temp.getUserId()));
				result.put("message", SUCCESS);
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
	
//	@PostMapping("/login")
//	public ResponseEntity<?> login(UserDto user) throws Exception {
//		Map<String, Object> result = new HashMap<String,Object>();
//		result.put("access-token", jwtUtil.createToken("id",user.getUserId()));
//		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.ACCEPTED);
//	}
	
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
}
