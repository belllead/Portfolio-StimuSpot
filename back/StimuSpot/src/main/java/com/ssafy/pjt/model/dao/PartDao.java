package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.PartDto;

public interface PartDao {

	List<PartDto> selectAll(int userNum);
	
}
