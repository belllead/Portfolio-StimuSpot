package com.ssafy.pjt.model.dto;

public class DiaryQueryDto {

	String startDate;
	String endDate;
	int userNum;
	String specificDate;

	public DiaryQueryDto() {
	}

	public String getSpecificDate() {
		return specificDate;
	}

	public void setSpecificDate(String specificDate) {
		this.specificDate = specificDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

}
