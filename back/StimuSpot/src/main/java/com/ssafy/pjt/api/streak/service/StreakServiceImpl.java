package com.ssafy.pjt.api.streak.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.StreakDao;
import com.ssafy.pjt.model.dto.StreakDto;

@Service
public class StreakServiceImpl implements StreakService {

	@Autowired
	StreakDao dao;

	// 최근 20개 스트릭 시작일을 가져와서
	// 오늘로부터 30일 이내에 포함되는 날짜들만 반환
	@Override
	public List<String> get30DayStreak() throws ParseException {
		List<StreakDto> recent = dao.select20Streak();

		List<String> workoutDates = new ArrayList<>();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -30);
		Date threshold = cal.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < recent.size(); i++) {
			String date = recent.get(i).getStreakStartDate();
			Date startDate = formatter.parse(date);

			cal.setTime(startDate);

			if (threshold.after(cal.getTime()))
				continue;

			for (int j = 0; j < recent.get(i).getStreakPassed(); j++) {
				String el = formatter.format(cal.getTime()).replace("-", "");
				workoutDates.add(el);

				cal.add(Calendar.DATE, 1);
			}
		}
		return workoutDates;
	}

	@Override
	public int getLongestStreak() {
		return dao.selectLongestStreak();
	}

	@Override
	public int getCurrentStreak() throws ParseException {
		// 가장 최근 스트릭
		StreakDto recentStreak = dao.selectRecentStreak();

		// 현재 날짜를 threshold로 저장
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date threshold = cal.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		// 가장 최근 스트릭의 시작일 날짜 초기화
		String date = recentStreak.getStreakStartDate();
		Date startDate = formatter.parse(date);

		// calendar 객체에 현재 스트릭의 마지막 날짜 저장
		cal.setTime(startDate);
		cal.add(Calendar.DATE, recentStreak.getStreakPassed());

		// 기준(오늘) 날짜가 최근 스트릭의 마지막 날짜보다 뒤면 0 반환
		if (threshold.after(cal.getTime()))
			return 0;
		else
			return recentStreak.getStreakPassed();
	}

}
