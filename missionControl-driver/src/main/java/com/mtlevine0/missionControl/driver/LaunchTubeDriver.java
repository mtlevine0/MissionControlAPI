package com.mtlevine0.missionControl.driver;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class LaunchTubeDriver {
	
	private int tubeId;
	private GpioPinDigitalOutput tubePin;
	
	public LaunchTubeDriver(int tubeId, GpioPinDigitalOutput tubePin) {
		this.tubeId = tubeId;
		this.tubePin = tubePin;		
	}
	
	public void launchTube() {        
        System.out.println(this.tubeId + " - HIGH!");

		tubePin.high();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tubePin.low();
		System.out.println(this.tubeId + " - LOW!");
	}

}
