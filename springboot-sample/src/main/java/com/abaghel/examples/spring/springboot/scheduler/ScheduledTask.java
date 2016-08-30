package com.abaghel.examples.spring.springboot.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	
	@Autowired
	MyService service;


	@Scheduled(fixedRate = 5000)
	public void process() {
		System.out.println("Processing at " + service.getNextMessage());
	}

}
