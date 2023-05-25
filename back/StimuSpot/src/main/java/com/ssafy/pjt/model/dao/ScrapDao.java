package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.ScrapDto;

public interface ScrapDao {
	
	public List<ScrapDto> selectAll(int userNum);
	
	public ScrapDto selectById(int id);
	
	public int insertScrap(ScrapDto scrap);
	
	public int deleteScrap(int id);
	
	public int updateScrap(ScrapDto scrap);
}
