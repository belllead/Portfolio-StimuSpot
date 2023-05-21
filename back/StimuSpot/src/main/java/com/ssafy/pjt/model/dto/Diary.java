package com.ssafy.pjt.model.dto;

public class Diary {
	private int diary_id;
	private int user_num;
	private String diary_title;
	private String diary_regdate;
	private int diary_rating;
	private String diary_content;
	
	public Diary() {
	}

	public Diary(int diary_id, int user_num, String diary_title, String diary_regdate, int diary_rating,
			String diary_content) {
		super();
		this.diary_id = diary_id;
		this.user_num = user_num;
		this.diary_title = diary_title;
		this.diary_regdate = diary_regdate;
		this.diary_rating = diary_rating;
		this.diary_content = diary_content;
	}

	public int getDiary_id() {
		return diary_id;
	}

	public void setDiary_id(int diary_id) {
		this.diary_id = diary_id;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getDiary_title() {
		return diary_title;
	}

	public void setDiary_title(String diary_title) {
		this.diary_title = diary_title;
	}

	public String getDiary_regdate() {
		return diary_regdate;
	}

	public void setDiary_regdate(String diary_regdate) {
		this.diary_regdate = diary_regdate;
	}

	public int getDiary_rating() {
		return diary_rating;
	}

	public void setDiary_rating(int diary_rating) {
		this.diary_rating = diary_rating;
	}

	public String getDiary_content() {
		return diary_content;
	}

	public void setDiary_content(String diary_content) {
		this.diary_content = diary_content;
	}

	@Override
	public String toString() {
		return "Diary [diary_id=" + diary_id + ", user_num=" + user_num + ", diary_title=" + diary_title
				+ ", diary_regdate=" + diary_regdate + ", diary_rating=" + diary_rating + ", diary_content="
				+ diary_content + "]";
	}
}
