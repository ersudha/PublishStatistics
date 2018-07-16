package com.sudha.test.business.util;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.sudha.stats.business.util.DateUtil;

public class DateUtilTest {

	@Test
	public void convertToLocalDateTime() {
		LocalDateTime date = DateUtil.convertToLocalDateTime(1506851130000l);
		Assert.assertEquals(LocalDateTime.of(2017, 10, 01, 9, 45, 30), date);
	}
	
	@Test
	public void converToTimeStamp() {

		Long timestamp = DateUtil.converToTimeStamp(LocalDateTime.of(2017, 10, 01, 9, 45, 30));
		Assert.assertEquals(Long.valueOf(1506851130000l), timestamp);
		
	}
	
}
