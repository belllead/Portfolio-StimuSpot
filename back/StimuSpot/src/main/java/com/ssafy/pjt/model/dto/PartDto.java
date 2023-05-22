package com.ssafy.pjt.model.dto;

public class PartDto {
	int partId;
	String partName;
	String lastWorkout;
	String partContent;
	String partIcon;

	public PartDto() {
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartContent() {
		return partContent;
	}

	public void setPartContent(String partContent) {
		this.partContent = partContent;
	}

	public String getPartIcon() {
		return partIcon;
	}

	public void setPartIcon(String partIcon) {
		this.partIcon = partIcon;
	}

	public String getLastWorkout() {
		return lastWorkout;
	}

	public void setLastWorkout(String lastWorkout) {
		this.lastWorkout = lastWorkout;
	}
}
