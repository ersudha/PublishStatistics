package com.sudha.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sudha.test.business.service.StatisticServiceTest;
import com.sudha.test.business.service.TransactionServiceTest;
import com.sudha.test.business.util.DateUtilTest;
import com.sudha.test.presentation.controller.StatisticControllerTest;
import com.sudha.test.presentation.controller.TransactionControllerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DateUtilTest.class, StatisticServiceTest.class, TransactionServiceTest.class, TransactionControllerTest.class, StatisticControllerTest.class })
public class TestSuite {

}
