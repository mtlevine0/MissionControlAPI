package com.mtlevine0.missionControl.api.util;

import com.mtlevine0.missionControl.api.model.LaunchTube;
import com.mtlevine0.missionControl.driver.LaunchTubeDriver;

public class LaunchTubeTimer implements Runnable {

	private LaunchTube launchTube;

	public LaunchTubeTimer(LaunchTube launchTube) {
		this.launchTube = launchTube;
	}

	public void run() {

		try {
			Thread.sleep((long) launchTube.getDelayTime() * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LaunchTubeDriver tubeDriver = new LaunchTubeDriver(launchTube.getTubeId());
		tubeDriver.launchTube();
		System.out.println("LaunchTube " + launchTube.getTubeId() + " Delay: " + launchTube.getDelayTime());

	}
}
