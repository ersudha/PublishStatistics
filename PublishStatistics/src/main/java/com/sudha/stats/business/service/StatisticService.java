package com.sudha.stats.business.service;

import java.util.List;

import com.sudha.stats.exception.TransactionExpiredException;
import com.sudha.stats.exception.TransactionOutOfFutureWindow;
import com.sudha.stats.persistence.entity.Statistic;
import com.sudha.stats.persistence.entity.Transaction;

public interface StatisticService {
	
	public List<Statistic> findAll();
	public Statistic findCurrent();
	
	public void add(Transaction transaction) throws TransactionExpiredException, TransactionOutOfFutureWindow;
	
}
