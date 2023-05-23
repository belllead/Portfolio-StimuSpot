package com.ssafy.pjt.api.part.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.PartDao;
import com.ssafy.pjt.model.dto.PartDto;

@Service
public class PartServiceImpl implements PartService {

	@Autowired
	PartDao dao;

	@Override
	public List<PartDto> getPartList(int userNum) {
		return dao.selectAll(userNum);
	}

	@Override
	public Map<Integer, Integer> getPartScore(int userNum) throws ParseException {
		Map<Integer, Integer> map = new HashMap<>();

		List<PartDto> list = dao.selectAll(userNum);

		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");

		for (int i = 1; i <= 10; i++)
			map.put(i, null);

		for (int i = 0; i < list.size(); i++) {
			PartDto part = list.get(i);

			Date lastWorkOut = sdf1.parse(part.getLastWorkout());

			cal.setTime(lastWorkOut);

			int a = Integer.parseInt(sdf2.format(now));
			int b = Integer.parseInt(sdf2.format(cal.getTime()));

			int score = a - b;
			if (score <= 2)
				score = 10;
			else if (score <= 4)
				score = 9;
			else if (score <= 6)
				score = 8;
			else if (score <= 8)
				score = 7;
			else if (score <= 10)
				score = 6;
			else if (score <= 12)
				score = 5;
			else if (score <= 14)
				score = 4;
			else if (score <= 16)
				score = 3;
			else if (score <= 18)
				score = 2;
			else if (score <= 20)
				score = 1;
			else
				score = 0;

			map.replace(part.getPartId(), score);
		}

		return map;
	}

}
