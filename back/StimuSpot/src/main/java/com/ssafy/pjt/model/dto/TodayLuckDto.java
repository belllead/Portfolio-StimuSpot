package com.ssafy.pjt.model.dto;

public class TodayLuckDto {
	int luckId;
	String luckContent;

	public TodayLuckDto() {
		super();
	}

	public int getLuckId() {
		return luckId;
	}

	public void setLuckId(int luckId) {
		this.luckId = luckId;
	}

	public String getLuckContent() {
		return luckContent;
	}

	public void setLuckContent(String luckContent) {
		this.luckContent = luckContent;
	}

}
