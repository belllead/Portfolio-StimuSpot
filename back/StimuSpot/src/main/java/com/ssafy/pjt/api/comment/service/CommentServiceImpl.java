package com.ssafy.pjt.api.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pjt.model.dao.CommentDao;
import com.ssafy.pjt.model.dto.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao;
	
	@Autowired
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<CommentDto> readCommentByScrap(int id) {
		return commentDao.selectByScrap(id);
	}

	@Transactional
	@Override
	public boolean writeComment(CommentDto comment) {
		return commentDao.createComment(comment) > 0;
	}

	@Transactional
	@Override
	public boolean removeComment(int id) {
		return commentDao.deleteComment(id) > 0;
	}

	@Transactional
	@Override
	public boolean removeCommentByScrap(int scrapId) {
		return commentDao.deleteCommentByScrap(scrapId) > 0;
	}

}
