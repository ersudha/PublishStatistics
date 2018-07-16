package com.sudha.stats.business.service;

import com.sudha.stats.exception.TransactionExpiredException;
import com.sudha.stats.exception.TransactionOutOfFutureWindow;
import com.sudha.stats.persistence.entity.Transaction;
import com.sudha.stats.presentation.json.TransactionPostJson;

public interface TransactionService {
	
	public Transaction process(TransactionPostJson json) throws TransactionExpiredException, TransactionOutOfFutureWindow;

}
