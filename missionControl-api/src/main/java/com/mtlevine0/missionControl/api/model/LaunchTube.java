package com.mtlevine0.missionControl.api.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class LaunchTube {

	@Id
	private int tubeId;
	private int delayTime;
	private boolean hasLaunched = false;
	
	public LaunchTube() {}

	public int getTubeId() {
		return tubeId;
	}

	public void setTubeId(int tubeId) {
		this.tubeId = tubeId;
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}

	public boolean isLaunched() {
		return hasLaunched;
	}

	public void setLaunched(boolean launched) {
		this.hasLaunched = launched;
	}
	
}
