package com.ssafy.pjt.api.comment.service;

import java.util.List;

import com.ssafy.pjt.model.dto.CommentDto;

public interface CommentService {
	
	// scrapId로 코멘트 조회
	public List<CommentDto> readCommentByScrap(int id);
	
	// 코멘트 등록
	public boolean writeComment(CommentDto comment);
	
	// 코멘트 삭제
	public boolean removeComment(int id);
	
	// 스크랩 삭제로 인한 강제 삭제
	public boolean removeCommentByScrap(int scrapId);
}
