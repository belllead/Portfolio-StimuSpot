package com.ssafy.pjt.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	private static final String SALT = "SSAFIT";
	
	
	// 토큰 생성
	// 인자로 키와 벨류 넘어옴(한 가지 정보만 넣는다고 가정)
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return Jwts.builder()
		.setHeaderParam("alg", "HW256")
		.setHeaderParam("typ", "JWT") //헤더
		.claim(claimId, data)
//		.setExpiration(new Date(System.currentTimeMillis()+3000)) // 페이로드
		.signWith(SignatureAlgorithm.HS256,SALT.getBytes("UTF-8")) // 서명
		.compact();
	}
	
	// 유효성 검사
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}

}
