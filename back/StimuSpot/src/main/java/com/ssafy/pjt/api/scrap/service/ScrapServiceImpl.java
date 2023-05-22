package com.ssafy.pjt.api.scrap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.ScrapDao;
import com.ssafy.pjt.model.dto.Scrap;

@Service
public class ScrapServiceImpl implements ScrapService {

	private ScrapDao scrapDao;
	
	@Autowired
	public void setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
	}
	
	@Override
	public List<Scrap> getScrapList() {
		return scrapDao.selectAll();
	}

	@Override
	public Scrap readScrapById(int id) {
		return scrapDao.selectById(id);
	}

	@Override
	public boolean writeScrap(Scrap scrap) {
		return scrapDao.insertScrap(scrap) > 0;
	}

	@Override
	public boolean removeScrap(int id) {
		return scrapDao.deleteScrap(id) > 0;
	}

	@Override
	public boolean modifyScrap(Scrap scrap) {
		return scrapDao.updateScrap(scrap) > 0;
	}
}
