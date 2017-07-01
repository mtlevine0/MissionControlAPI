package com.mtlevine0.missionControl.driver;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LaunchTubeDriver {
	
	private int tubeId;
	
	GpioPinDigitalOutput tubePin;
	GpioController gpio;
	
	public LaunchTubeDriver(int tubeId) {
		
		this.tubeId = tubeId;
		
		String tubeString = "GPIO_0" + tubeId;
		
        gpio = GpioFactory.getInstance();
        tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "tube"+tubeId, PinState.LOW);
        
        tubePin.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        
	}
	
	public void launchTube() {        
        System.out.println(this.tubeId + " - HIGH!");

		tubePin.high();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tubePin.low();

		System.out.println(this.tubeId + " - LOW!");
		
		gpio.shutdown();
	}

}
