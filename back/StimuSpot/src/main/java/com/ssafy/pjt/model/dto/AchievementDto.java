package com.ssafy.pjt.model.dto;

public class AchievementDto {
	int achvId;
	String achvTitle;
	String achvContent;
	String achievedDate;

	public AchievementDto() {
	}

	public int getAchvId() {
		return achvId;
	}

	public void setAchvId(int achvId) {
		this.achvId = achvId;
	}

	public String getAchvTitle() {
		return achvTitle;
	}

	public void setAchvTitle(String achvTitle) {
		this.achvTitle = achvTitle;
	}

	public String getAchvContent() {
		return achvContent;
	}

	public void setAchvContent(String achvContent) {
		this.achvContent = achvContent;
	}

	public String getAchievedDate() {
		return achievedDate;
	}

	public void setAchievedDate(String achievedDate) {
		this.achievedDate = achievedDate;
	}
}
