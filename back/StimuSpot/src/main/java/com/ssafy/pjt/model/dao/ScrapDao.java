package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.Scrap;

public interface ScrapDao {
	
	public List<Scrap> selectAll();
	
	public Scrap selectById(int id);
	
	public int insertScrap(Scrap scrap);
	
	public int deleteScrap(int id);
	
	public int updateScrap(Scrap scrap);
}
