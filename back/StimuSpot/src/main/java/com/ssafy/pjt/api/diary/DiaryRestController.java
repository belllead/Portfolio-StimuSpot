package com.ssafy.pjt.api.diary;

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

import com.ssafy.pjt.api.diary.service.DiaryService;
import com.ssafy.pjt.model.dto.DiaryDto;
import com.ssafy.pjt.model.dto.DiaryQueryDto;
import com.ssafy.pjt.util.ErrorHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "다이어리 컨트롤러")
@RequestMapping("/diary-api")
@CrossOrigin("*")
public class DiaryRestController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	DiaryService service;

	@ApiOperation("다이어리 월별 보기 - 달력에 보이는 시작일과 끝일 사이 일기 반환")
	@GetMapping("")
	public ResponseEntity<?> getDiaryList(DiaryQueryDto diaryList) {
		List<DiaryDto> list = service.getDiaryList(diaryList);

		try {
			if (list == null || list.isEmpty())
				return new ResponseEntity<String>("해당 기간동안 등록된 일기가 없습니다.", HttpStatus.NO_CONTENT);

			return new ResponseEntity<List<DiaryDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

	// 여러 사용자가 같은 날에 일기를 썼을 수도 있으니
	// 사용자 번호와 일기 날짜를 같이 매개변수로 보내야 함
	@ApiOperation(value = "다이어리 상세보기 - 특정 날짜의 다이어리 반환")
	@GetMapping("/detail")
	public ResponseEntity<?> getDiaryDetail(DiaryQueryDto diaryOne) {
		DiaryDto diary = service.readDiary(diaryOne);

		try {
			if (diary == null)
				return new ResponseEntity<String>("해당 날짜에 일기가 없습니다.", HttpStatus.NO_CONTENT);

			return new ResponseEntity<DiaryDto>(diary, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

	@ApiOperation(value = "다이어리 등록", response = String.class)
	@PostMapping("")
	public ResponseEntity<?> createDiary(@RequestBody DiaryDto diary) {
		try {
			if (service.writeDiary(diary))
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

	// 왜 수정된 내용의 다이어리 안 보냄?
	@ApiOperation(value = "다이어리 수정", response = String.class)
	@PutMapping("")
	public ResponseEntity<?> modifyDiary(@RequestBody DiaryDto diary) {
		try {
			if (service.modifyDiary(diary))
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

	@ApiOperation(value = "다이어리 삭제", response = String.class)
	@DeleteMapping("/{diaryId}")
	public ResponseEntity<?> deleteDiary(@PathVariable int diaryId) {
		try {
			if (service.removeDiary(diaryId))
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			else
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

}
