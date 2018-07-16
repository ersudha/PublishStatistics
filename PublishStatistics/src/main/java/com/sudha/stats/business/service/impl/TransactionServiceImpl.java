package com.sudha.stats.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudha.stats.business.service.StatisticService;
import com.sudha.stats.business.service.TransactionService;
import com.sudha.stats.business.util.DateUtil;
import com.sudha.stats.exception.TransactionExpiredException;
import com.sudha.stats.exception.TransactionOutOfFutureWindow;
import com.sudha.stats.persistence.entity.Transaction;
import com.sudha.stats.presentation.json.TransactionPostJson;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private StatisticService statisticService;

	@Override
	public Transaction process(TransactionPostJson json) throws TransactionExpiredException, TransactionOutOfFutureWindow {
		
		Transaction transaction = new Transaction();
		transaction.setAmount(json.getAmount());
		transaction.setDate(DateUtil.convertToLocalDateTime(json.getTimestamp()));
		
		this.statisticService.add(transaction);
		
		return transaction;
		
	}
	
}
