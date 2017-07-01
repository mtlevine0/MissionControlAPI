package com.mtlevine0.missionControl.api.util;

import com.mtlevine0.missionControl.api.model.LaunchTube;
import com.mtlevine0.missionControl.driver.LaunchTubeDriver;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class LaunchTubeTimer implements Runnable {

	private LaunchTube launchTube;
	private GpioPinDigitalOutput tubePin;
	
	public LaunchTubeTimer(LaunchTube launchTube, GpioPinDigitalOutput tubePin) {
		this.launchTube = launchTube;
		this.tubePin = tubePin;
	}

	public void run() {

		try {
			Thread.sleep((long) launchTube.getDelayTime() * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		LaunchTubeDriver tubeDriver = new LaunchTubeDriver(launchTube.getTubeId(), tubePin);
		tubeDriver.launchTube();
		System.out.println("LaunchTube " + launchTube.getTubeId() + " Delay: " + launchTube.getDelayTime());

	}
}
