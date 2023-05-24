package com.ssafy.pjt.model.dto;

import java.util.List;

public class DiaryDto {
	int diaryId;
	int userNum;
	String diaryTitle;
	String diaryRegdate;
	int diaryRating;
	String diaryContent;
	List<Integer> partIds;
	List<String> partNames;

	public DiaryDto() {
	}

	public int getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getDiaryTitle() {
		return diaryTitle;
	}

	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public String getDiaryRegdate() {
		return diaryRegdate;
	}

	public void setDiaryRegdate(String diaryRegdate) {
		this.diaryRegdate = diaryRegdate;
	}

	public int getDiaryRating() {
		return diaryRating;
	}

	public void setDiaryRating(int diaryRating) {
		this.diaryRating = diaryRating;
	}

	public String getDiaryContent() {
		return diaryContent;
	}

	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}

	public List<Integer> getPartIds() {
		return partIds;
	}

	public void setPartIds(List<Integer> partIds) {
		this.partIds = partIds;
	}

	public List<String> getPartNames() {
		return partNames;
	}

	public void setPartNames(List<String> partNames) {
		this.partNames = partNames;
	}

	@Override
	public String toString() {
		return "DiaryDto [diaryId=" + diaryId + ", userNum=" + userNum + ", diaryTitle=" + diaryTitle
				+ ", diaryRegdate=" + diaryRegdate + ", diaryRating=" + diaryRating + ", diaryContent=" + diaryContent
				+ ", partIds=" + partIds + "]";
	}

}
