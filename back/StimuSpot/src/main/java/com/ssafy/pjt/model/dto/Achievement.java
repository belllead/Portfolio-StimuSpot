package com.ssafy.pjt.model.dto;

public class Achievement {
	private int achv_id;
	private String achv_title;
	private String achv_content;
	
	public Achievement() {
	}

	public Achievement(int achv_id, String achv_title, String achv_content) {
		super();
		this.achv_id = achv_id;
		this.achv_title = achv_title;
		this.achv_content = achv_content;
	}

	public int getAchv_id() {
		return achv_id;
	}

	public void setAchv_id(int achv_id) {
		this.achv_id = achv_id;
	}

	public String getAchv_title() {
		return achv_title;
	}

	public void setAchv_title(String achv_title) {
		this.achv_title = achv_title;
	}

	public String getAchv_content() {
		return achv_content;
	}

	public void setAchv_content(String achv_content) {
		this.achv_content = achv_content;
	}

	@Override
	public String toString() {
		return "Achievement [achv_id=" + achv_id + ", achv_title=" + achv_title + ", achv_content=" + achv_content
				+ "]";
	}	
}
