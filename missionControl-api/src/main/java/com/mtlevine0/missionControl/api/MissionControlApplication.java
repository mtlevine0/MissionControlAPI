package com.mtlevine0.missionControl.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@SpringBootApplication
public class MissionControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionControlApplication.class, args);
		System.out.println("MissionControl API is Running!");
	}
	
	@Bean
	public List<GpioPinDigitalOutput> createGpio() {
		System.out.println("GPIO created!");
		final GpioController gpio = GpioFactory.getInstance();
		
		List<GpioPinDigitalOutput> pinList = new ArrayList<GpioPinDigitalOutput>();
		
		final GpioPinDigitalOutput pin0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.HIGH);
        pin0.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
		final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.HIGH);
        pin1.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
		final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.HIGH);
        pin2.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
		final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.HIGH);
        pin3.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
		final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.HIGH);
        pin4.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
		final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.HIGH);
        pin5.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
		final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.HIGH);
        pin6.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
		final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.HIGH);
        pin7.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
        
        pinList.add(pin0);
        pinList.add(pin1);
        pinList.add(pin2);
        pinList.add(pin3);
        pinList.add(pin4);
        pinList.add(pin5);
        pinList.add(pin6);
        pinList.add(pin7);
        
        return pinList;
	}
}
