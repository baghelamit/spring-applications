package com.abaghel.examples.spring.springboot.spel;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import junit.framework.Assert;

public class SpringSpELTest {

	@Test
	public void testCompareDate() throws Exception {
		ZonedDateTime date1 = ZonedDateTime.now(ZoneId.systemDefault());
		String otherDate = "2010-12-25 12:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").withZone(ZoneId.systemDefault());
		ZonedDateTime date2 = ZonedDateTime.parse(otherDate, formatter);
		CompareDateSpEL cs = new CompareDateSpEL();
		int value = cs.compareDate(date1, date2);
		// "zonedDateTime" is greater than "otherDate"
		Assert.assertEquals(1, value);
	}

}
