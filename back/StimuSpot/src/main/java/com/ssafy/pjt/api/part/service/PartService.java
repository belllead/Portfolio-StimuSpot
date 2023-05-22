package com.ssafy.pjt.api.part.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.ssafy.pjt.model.dto.PartDto;

public interface PartService {

	List<PartDto> getPartList(int userNum);

	Map<Integer, Integer> getPartScore(int userNum) throws ParseException;
}
