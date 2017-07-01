package com.mtlevine0.missionControl.api.util;

import com.mtlevine0.missionControl.api.model.LaunchTube;
import com.mtlevine0.missionControl.driver.LaunchTubeDriver;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

public class LaunchTubeTimer implements Runnable {

	private LaunchTube launchTube;
	private GpioController gpio;

	public LaunchTubeTimer(LaunchTube launchTube, GpioController gpio) {
		this.launchTube = launchTube;
		this.gpio = gpio;
	}

	public void run() {

		try {
			Thread.sleep((long) launchTube.getDelayTime() * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LaunchTubeDriver tubeDriver = new LaunchTubeDriver(launchTube.getTubeId(), gpio);
		tubeDriver.launchTube();
		System.out.println("LaunchTube " + launchTube.getTubeId() + " Delay: " + launchTube.getDelayTime());

	}
}
