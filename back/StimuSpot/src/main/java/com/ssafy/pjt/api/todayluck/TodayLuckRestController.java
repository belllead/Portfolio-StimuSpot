package com.ssafy.pjt.api.todayluck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.api.todayluck.service.TodayluckService;
import com.ssafy.pjt.model.dto.TodayLuckDto;
import com.ssafy.pjt.util.ErrorHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "운세 컨트롤러")
@RequestMapping("/today-luck-api")
public class TodayLuckRestController {

	@Autowired
	TodayluckService service;
	
	@ApiOperation("랜덤으로 운세 하나 반환 (현재 보이는 운세가 있다면 그 운세 제외하고 탐색)")
	@GetMapping("")
	public ResponseEntity<?> getRandomLuck(@RequestParam(required = false, defaultValue = "0") int luckId) {
		TodayLuckDto luck = service.getRandomLuck(luckId);
		
		try {
			if (luck == null)
				return new ResponseEntity<String>("There is no luck left", HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<TodayLuckDto>(luck, HttpStatus.OK);
		} catch (Exception e) {
			return ErrorHandler.exceptionHandling(e);
		}
	}
	
	

}
