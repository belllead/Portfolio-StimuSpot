package com.ssafy.pjt.api.scrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.api.scrap.service.ScrapService;
import com.ssafy.pjt.model.dto.Scrap;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "스크랩 컨트롤러")
@RequestMapping("/scrap-api")
@CrossOrigin("*")
public class ScrapController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	ScrapService service;
	
	@ApiOperation(value= "스크랩 리스트 조회", response = List.class)
	@GetMapping("/scrap")
	public ResponseEntity<?> getScrapList(){
		List<Scrap> list = service.getScrapList();
		try {
			if(list == null || list.isEmpty() ) return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
			else return new ResponseEntity<List<Scrap>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "id로 스크랩 조회", response = Scrap.class)
	@GetMapping("/scrap/{id}")
	public ResponseEntity<?> getScrapById(@PathVariable int id){
		Scrap scrap = service.readScrapById(id);
		try {
			if(scrap != null) return new ResponseEntity<Scrap>(scrap,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	@ApiOperation(value= "스크랩 등록", response = String.class)
	@PostMapping("/scrap")
	public ResponseEntity<?> createScrap(@RequestBody Scrap scrap){
		try {
			if(service.writeScrap(scrap)) return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NOT_ACCEPTABLE);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "스크랩 수정", response = String.class)
	@PutMapping("/scrap")
	public ResponseEntity<?> modifyScrap(@RequestBody Scrap scrap){
		try {
			if(service.modifyScrap(scrap)) return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NOT_ACCEPTABLE);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "스크랩 삭제", response = String.class)
	@DeleteMapping("/scrap/{id}")
	public ResponseEntity<?> deleteScrap(@PathVariable int id){
		try {
			if(service.removeScrap(id)) return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NOT_ACCEPTABLE);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e){
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
