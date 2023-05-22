package com.ssafy.pjt.api.part;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "운동 부위 컨트롤러")
@RequestMapping("/part-api")
public class PartRestController {

	@ApiOperation("가장 최근 자극된 순으로 정렬해서 가져오기 (겹치면 큰근육 순) 부위 테이블이랑 JOIN해서 정보 다 가져오기 => 부위 순위")
	@GetMapping("")
	public ResponseEntity<?> getPartList() {
		return null;
	}
	
	@ApiOperation("해당 부위로 운동한 날짜 => 점수 매겨서 부위 그림")
	@GetMapping("/{part}")
	public ResponseEntity<?> getPartScore() {
		return null;
	}
	
	@ApiOperation("특정 다이어리와 연결된 운동 부위 => 일기 상세보기")
	@GetMapping("/{diaryId}")
	public ResponseEntity<?> getPart() {
		return null;
	}
}
