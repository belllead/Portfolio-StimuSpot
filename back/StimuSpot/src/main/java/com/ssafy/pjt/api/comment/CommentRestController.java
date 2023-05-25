package com.ssafy.pjt.api.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.api.comment.service.CommentService;
import com.ssafy.pjt.model.dto.CommentDto;
import com.ssafy.pjt.model.dto.ScrapDto;
import com.ssafy.pjt.util.ErrorHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "코멘트 컨트롤러")
@RequestMapping("/comment-api")
@CrossOrigin("*")
public class CommentRestController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	CommentService service;
	
	@ApiOperation(value= "코멘트 리스트 조회", response = List.class)
	@GetMapping("/")
	public ResponseEntity<?> getCommentList(@RequestParam(required = true) int id){
		List<CommentDto> list = service.readCommentByScrap(id);
		try {
			if(list == null || list.isEmpty() ) return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
			else return new ResponseEntity<List<CommentDto>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "코멘트 등록", response = String.class)
	@PostMapping("/")
	public ResponseEntity<?> createComment(@RequestBody CommentDto comment){
		try {
			if(service.writeComment(comment)) return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NOT_ACCEPTABLE);
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "코멘트 삭제", response = String.class)
	@DeleteMapping("/")
	public ResponseEntity<?> deleteComment(@RequestParam(required = true) int id){
		try {
			if(service.removeComment(id)) return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NOT_ACCEPTABLE);
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
	@ApiOperation(value= "스크랩 삭제로 인한 코멘트 삭제", response = String.class)
	@DeleteMapping("/byscrap")
	public ResponseEntity<?> deleteCommentByScrap(@RequestParam(required = true) int id){
		try {
			if(service.removeCommentByScrap(id)) return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
			else return new ResponseEntity<String>(FAIL,HttpStatus.NOT_ACCEPTABLE);
		}catch(Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
}
