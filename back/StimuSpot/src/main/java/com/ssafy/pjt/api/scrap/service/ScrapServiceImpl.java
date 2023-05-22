package com.ssafy.pjt.api.scrap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pjt.model.dao.ScrapDao;
import com.ssafy.pjt.model.dto.ScrapDto;

@Service
public class ScrapServiceImpl implements ScrapService {

	private ScrapDao scrapDao;
	
	@Autowired
	public void setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
	}
	
	@Override
	public List<ScrapDto> getScrapList() {
		return scrapDao.selectAll();
	}

	@Override
	public ScrapDto readScrapById(int id) {
		return scrapDao.selectById(id);
	}

	@Transactional
	@Override
	public boolean writeScrap(ScrapDto scrap) {
		return scrapDao.insertScrap(scrap) > 0;
	}

	@Transactional
	@Override
	public boolean removeScrap(int id) {
		return scrapDao.deleteScrap(id) > 0;
	}

	@Transactional
	@Override
	public boolean modifyScrap(ScrapDto scrap) {
		return scrapDao.updateScrap(scrap) > 0;
	}
}
