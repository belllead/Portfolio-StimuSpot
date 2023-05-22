package com.ssafy.pjt.api.scrap.service;

import java.util.List;

import com.ssafy.pjt.model.dto.Scrap;

public interface ScrapService {
	
	// 전체 스크랩 조회
	public List<Scrap> getScrapList();
	
	// id로 스크랩 조회
	public Scrap readScrapById(int id);
	
	// 스크랩 작성
	public boolean writeScrap(Scrap scrap);
	
	// 스크랩 삭제
	public boolean removeScrap(int id);
	
	// 스크랩 수정
	public boolean modifyScrap(Scrap scrap);
}
