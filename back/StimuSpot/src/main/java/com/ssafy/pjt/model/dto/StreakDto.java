package com.ssafy.pjt.model.dto;

public class StreakDto {
	int streakId;
	int userNum;
	String streakStartDate;
	int streakPassed;

	public StreakDto() {
		super();
	}

	public int getStreakId() {
		return streakId;
	}

	public void setStreakId(int streakId) {
		this.streakId = streakId;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getStreakStartDate() {
		return streakStartDate;
	}

	public void setStreakStartDate(String streakStartDate) {
		this.streakStartDate = streakStartDate;
	}

	public int getStreakPassed() {
		return streakPassed;
	}

	public void setStreakPassed(int streakPassed) {
		this.streakPassed = streakPassed;
	}

	@Override
	public String toString() {
		return "Streak [streakId=" + streakId + ", userNum=" + userNum + ", streakStartDate=" + streakStartDate
				+ ", streakPassed=" + streakPassed + "]";
	}

}
