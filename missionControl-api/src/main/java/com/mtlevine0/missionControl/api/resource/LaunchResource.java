package com.mtlevine0.missionControl.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtlevine0.missionControl.api.model.LaunchTube;
import com.mtlevine0.missionControl.api.service.LaunchService;

@RestController
@RequestMapping("api/v1/launch")
public class LaunchResource {
	
	@Autowired
	LaunchService launchService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LaunchTube>> fireTubes() {

		List<LaunchTube> launchTubeList = launchService.getTubes();
		
		launchService.launchTubes();

		return new ResponseEntity<List<LaunchTube>>(launchTubeList, HttpStatus.OK); 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loadTubes(@RequestBody List<LaunchTube> launchTubes) {
		
		launchService.loadTubes(launchTubes);
		
		return "Loading Tube Sequence!";
	}

}
