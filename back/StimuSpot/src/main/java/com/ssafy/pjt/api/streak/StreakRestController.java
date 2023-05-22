package com.ssafy.pjt.api.streak;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.api.streak.service.StreakService;
import com.ssafy.pjt.util.ErrorHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "스트릭 컨트롤러")
@RequestMapping("/streak-api")
public class StreakRestController {

	@Autowired
	StreakService service;

	@ApiOperation("오늘부터 30일 이내를 포함한 스트릭 전부 반환 / (yyyymmdd) 형식으로 가공")
	@GetMapping("")
	public ResponseEntity<?> get30DayStreak() {
		try {
			List<String> list = service.get30DayStreak();
			
			if (list == null || list.isEmpty())
				return new ResponseEntity<String>("해당 기간에 기록된 스트릭이 없습니다.", HttpStatus.NO_CONTENT);

			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

	@ApiOperation("경과일 기준으로 정렬해서 가장 위 스트릭 반환")
	@GetMapping("/longest")
	public ResponseEntity<?> getLongestStreak() {
		int longest = service.getLongestStreak();

		try {
			if (longest == 0)
				return new ResponseEntity<String>("기록된 스트릭이 없습니다", HttpStatus.NO_CONTENT);

			return new ResponseEntity<Integer>(longest, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

	@ApiOperation("오늘을 포함한 스트릭이 있다면 반환 / 없으면 0")
	@GetMapping("/current")
	public ResponseEntity<?> getCurrentStreak() {
		try {
			int current = service.getCurrentStreak();
			return new ResponseEntity<Integer>(current, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

}
