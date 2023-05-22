package com.ssafy.pjt.model.dto;

public class Scrap {
	private int scrapId;
	private int userNum;
	private String scrapTitle;
	private String scrapUrl;
	private String scrapVtitle;
	private String scrapThumbnail;
	private String scrapContent;
	private String scrapRegdate;
	
	public Scrap() {
	}

	public int getScrapId() {
		return scrapId;
	}

	public void setScrapId(int scrapId) {
		this.scrapId = scrapId;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getScrapTitle() {
		return scrapTitle;
	}

	public void setScrapTitle(String scrapTitle) {
		this.scrapTitle = scrapTitle;
	}

	public String getScrapUrl() {
		return scrapUrl;
	}

	public void setScrapUrl(String scrapUrl) {
		this.scrapUrl = scrapUrl;
	}

	public String getScrapVtitle() {
		return scrapVtitle;
	}

	public void setScrapVtitle(String scrapVtitle) {
		this.scrapVtitle = scrapVtitle;
	}

	public String getScrapThumbnail() {
		return scrapThumbnail;
	}

	public void setScrapThumbnail(String scrapThumbnail) {
		this.scrapThumbnail = scrapThumbnail;
	}

	public String getScrapContent() {
		return scrapContent;
	}

	public void setScrapContent(String scrapContent) {
		this.scrapContent = scrapContent;
	}


	public String getScrapRegdate() {
		return scrapRegdate;
	}

	public void setScrapRegdate(String scrapRegdate) {
		this.scrapRegdate = scrapRegdate;
	}
	
	@Override
	public String toString() {
		return "Scrap [scrapId=" + scrapId + ", userNum=" + userNum + ", scrapTitle=" + scrapTitle + ", scrapUrl="
				+ scrapUrl + ", scrapVtitle=" + scrapVtitle + ", scrapThumbnail=" + scrapThumbnail + ", scrapContent="
				+ scrapContent + "]";
	}
}
