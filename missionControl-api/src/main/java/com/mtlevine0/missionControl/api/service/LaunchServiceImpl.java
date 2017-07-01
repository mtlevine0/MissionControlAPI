package com.mtlevine0.missionControl.api.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtlevine0.missionControl.api.MissionControlApplication;
import com.mtlevine0.missionControl.api.model.LaunchTube;
import com.mtlevine0.missionControl.api.repository.LaunchTubeRepository;
import com.mtlevine0.missionControl.api.util.LaunchTubeTimer;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

@Service
public class LaunchServiceImpl implements LaunchService {
	
	@Autowired
	LaunchTubeRepository launchTubeRepository;
	
	@Autowired
	MissionControlApplication app;

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

		List<GpioPinDigitalOutput> pinList = app.createGpio();

		for(LaunchTube tube : launchTubeList) {
			executorService.execute(new LaunchTubeTimer(tube, pinList.get(tube.getTubeId())));
		}
		
		executorService.shutdown();
		launchTubeRepository.deleteAll();
		
		return null;
	}

}
