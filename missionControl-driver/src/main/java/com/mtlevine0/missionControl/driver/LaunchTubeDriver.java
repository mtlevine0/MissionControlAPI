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
	
	public LaunchTubeDriver(int tubeId, GpioController gpio) {
		
		this.tubeId = tubeId;
		this.gpio = gpio;
//        gpio = GpioFactory.getInstance();        

		
		switch(this.tubeId) {
		case(0):
	        System.out.println("0");
	        tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
		case(1):
	        System.out.println("0");
	        tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);
		case(2):
	        System.out.println("0");
			tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
		case(3):
	        System.out.println("0");
			tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
		case(4):
	        System.out.println("0");
			tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
		case(5):
	        System.out.println("0");
			tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW);
		case(6):
	        System.out.println("0");
			tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW);
		case(7):
	        System.out.println("0");
			tubePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);
		}
		
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
		
//		gpio.shutdown();
	}

}
