package com.ssafy.pjt.model.dto;

public class CommentDto {
	private int commentId;
	private int scrapId;
	private String commentWriter;
	private String commentContent;
	
	public CommentDto() {
	}

	public CommentDto(int commentId, int scrapId, String commentWriter, String commentContent) {
		super();
		this.commentId = commentId;
		this.scrapId = scrapId;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getScrapId() {
		return scrapId;
	}

	public void setScrapId(int scrapId) {
		this.scrapId = scrapId;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
}
