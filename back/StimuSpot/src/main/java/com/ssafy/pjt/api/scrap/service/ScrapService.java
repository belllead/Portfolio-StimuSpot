package com.ssafy.pjt.api.scrap.service;

import java.util.List;

import com.ssafy.pjt.model.dto.ScrapDto;

public interface ScrapService {
	
	// 전체 스크랩 조회
	public List<ScrapDto> getScrapList();
	
	// id로 스크랩 조회
	public ScrapDto readScrapById(int id);
	
	// 스크랩 작성
	public boolean writeScrap(ScrapDto scrap);
	
	// 스크랩 삭제
	public boolean removeScrap(int id);
	
	// 스크랩 수정
	public boolean modifyScrap(ScrapDto scrap);
}
