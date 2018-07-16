package com.sudha.test.business.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sudha.stats.business.service.TransactionService;
import com.sudha.stats.business.util.DateUtil;
import com.sudha.stats.exception.TransactionExpiredException;
import com.sudha.stats.exception.TransactionOutOfFutureWindow;
import com.sudha.stats.persistence.entity.Transaction;
import com.sudha.stats.presentation.json.TransactionPostJson;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionServiceTest {
	
	@Autowired
	private TransactionService transactionService;
	
	@Value("${statisticService.windowInMs}")
	private Long windowInMs;
	
	@Test(expected = TransactionExpiredException.class)
	public void processExpired() throws TransactionExpiredException, TransactionOutOfFutureWindow {
		
		TransactionPostJson json = new TransactionPostJson();
		json.setAmount(6.0);
		json.setTimestamp(DateUtil.converToTimeStamp(LocalDateTime.now()) - windowInMs - 1000);
		
		this.transactionService.process(json);
	}
	
	@Test(expected = TransactionOutOfFutureWindow.class)
	public void processFuture() throws TransactionExpiredException, TransactionOutOfFutureWindow {
		
		TransactionPostJson json = new TransactionPostJson();
		json.setAmount(6.0);
		json.setTimestamp(DateUtil.converToTimeStamp(LocalDateTime.now()) + windowInMs + 1000);
		
		this.transactionService.process(json);
	}
	
	@Test
	public void processOk() throws TransactionExpiredException, TransactionOutOfFutureWindow {
		
		TransactionPostJson json = new TransactionPostJson();
		json.setAmount(6.0);
		json.setTimestamp(DateUtil.converToTimeStamp(LocalDateTime.now()) - windowInMs);
		
		Transaction transaction = this.transactionService.process(json);
		
		Assert.assertEquals(json.getAmount(), transaction.getAmount());
		Assert.assertEquals(DateUtil.convertToLocalDateTime(json.getTimestamp()), transaction.getDate());
	}

}
