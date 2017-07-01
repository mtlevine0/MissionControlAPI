package com.mtlevine0.missionControl.api.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtlevine0.missionControl.api.model.LaunchTube;
import com.mtlevine0.missionControl.api.repository.LaunchTubeRepository;
import com.mtlevine0.missionControl.api.util.LaunchTubeTimer;

@Service
public class LaunchServiceImpl implements LaunchService {
	
	@Autowired
	LaunchTubeRepository launchTubeRepository;

	@Override
	public void loadTubes(List<LaunchTube> launchTubes) {
		launchTubeRepository.save(launchTubes);
	}

	@Override
	public List<LaunchTube> getTubes() {
		return launchTubeRepository.findAll();
	}
	
	@Override
	public List<LaunchTube> launchTubes() {
				
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<LaunchTube> launchTubeList = launchTubeRepository.findAll();
		for(LaunchTube tube : launchTubeList) {
			executorService.execute(new LaunchTubeTimer(tube));
		}
		executorService.shutdown();
		launchTubeRepository.deleteAll();
		
		return null;
	}

}
