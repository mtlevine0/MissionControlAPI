package com.mtlevine0.missionControl.api.service;

import java.util.List;

import com.mtlevine0.missionControl.api.model.LaunchTube;

public interface LaunchService {

	void loadTubes(List<LaunchTube> launchTubes);

	List<LaunchTube> getTubes();

	List<LaunchTube> launchTubes();

}