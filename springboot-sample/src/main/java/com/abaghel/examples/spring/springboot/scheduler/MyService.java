package com.abaghel.examples.spring.springboot.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	
	public String getNextMessage(){
		 return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
	}
}
