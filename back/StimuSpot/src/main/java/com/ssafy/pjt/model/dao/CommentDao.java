package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.CommentDto;

public interface CommentDao {
	
	List<CommentDto> selectByScrap(int id);
	
	int createComment(CommentDto comment);
	
	int deleteComment(int id);
	
	int deleteCommentByScrap(int scrapId);
}
