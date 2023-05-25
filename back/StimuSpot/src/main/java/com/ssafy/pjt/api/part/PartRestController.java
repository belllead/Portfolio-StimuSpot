package com.ssafy.pjt.api.part;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.api.part.service.PartService;
import com.ssafy.pjt.model.dto.PartDto;
import com.ssafy.pjt.util.ErrorHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "운동 부위 컨트롤러")
@RequestMapping("/part-api")
public class PartRestController {

	@Autowired
	PartService service;
	
	@ApiOperation("자극된지 오래된 순으로 정렬해서 가져오기 (겹치면 큰근육 순) 부위 테이블이랑 JOIN해서 정보 다 가져오기 => 부위 순위")
	@GetMapping("")
	public ResponseEntity<?> getPartList(@RequestParam(required = true) int userNum) {
		List<PartDto> list = service.getPartList(userNum); 
		try {
			if (list == null || list.isEmpty())
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<List<PartDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
	@ApiOperation("해당 부위로 운동한 날짜 => 점수 매겨서 부위 그림")
	@GetMapping("/score")
	public ResponseEntity<?> getPartScore(@RequestParam(required = true) int userNum) {
		try {
			Map<Integer, Integer> map = service.getPartScore(userNum);
			
			if (map == null || map.isEmpty())
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<Map<Integer, Integer>>(map, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
}
