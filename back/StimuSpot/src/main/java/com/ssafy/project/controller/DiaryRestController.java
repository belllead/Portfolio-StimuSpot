package com.ssafy.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.model.dto.Diary;
import com.ssafy.project.model.service.DiaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(tags = "다이어리 컨트롤러")
@RestController
@RequestMapping("/diary-api")
@CrossOrigin("*")
public class DiaryRestController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	DiaryService service;
	
	@ApiOperation(value = "특정 날짜의 다이어리 반환", response = Diary.class)
	@GetMapping("/diary/{date}")
	public ResponseEntity<?> getDiaryByDayte(@PathVariable String date){
		Diary diary = service.readDiaryByDate(date);
		try {
			if(diary != null) return new ResponseEntity<Diary>(diary,HttpStatus.OK);
			else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "다이어리 등록", response = String.class)
	@PostMapping("/diary")
	public ResponseEntity<?> createDiary(@RequestBody Diary diary){
		try {
			if(service.writeDiary(diary)) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "다이어리 수정", response = String.class)
	@PutMapping("/diary/{id}")
	public ResponseEntity<?> modifyDiary(@PathVariable int id){
		try {
			if(service.modifyDiary(id)) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "다이어리 삭제", response = String.class)
	@DeleteMapping("/diary/{id}")
	public ResponseEntity<?> deleteDiary(@PathVariable int id){
		try {
			if(service.removeDiary(id)) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
		
	private ResponseEntity<String> exceptionHandling(Exception e){
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
