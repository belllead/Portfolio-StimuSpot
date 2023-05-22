package com.ssafy.pjt.api.achievement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.api.achievement.service.AchievementService;
import com.ssafy.pjt.model.dto.AchievementDto;
import com.ssafy.pjt.util.ErrorHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "업적 컨트롤러")
@RequestMapping("/achievement-api")
public class AchievementRestController {

	@Autowired
	AchievementService service;

	@ApiOperation(value = "전체 업적 반환", response = List.class)
	@GetMapping("")
	public ResponseEntity<?> getAchievementList() {
		List<AchievementDto> list = service.getAchievementList();
		try {
			if (list == null || list.isEmpty())
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<List<AchievementDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

	@ApiOperation(value = "유저가 달성한 업적 반환", response = List.class)
	@GetMapping("/{user_num}")
	public ResponseEntity<?> getAchievementListByUser(@PathVariable int user_num) {

		List<AchievementDto> list = service.getAchievementByUser(user_num);

		try {
			if (list == null || list.isEmpty())
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<List<AchievementDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}

}
