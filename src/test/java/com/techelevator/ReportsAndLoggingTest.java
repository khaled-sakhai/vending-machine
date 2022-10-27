package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportsAndLoggingTest {


    @Test
    void assertLogMessageMatch() {
        VendingMachineFunctions funcTest = new VendingMachineFunctions();
        String logMessageTestExpected = "";
        String logMessageToTest = "";
        String logMessageTestActual = "";
        funcTest.selectProduct("A1");
        logMessageTestActual = ReportsAndLogging.log(ReportsAndLogging.logMessageBuilderHelper());
        logMessageToTest.format("%5s %5s %.2f", "A1", "Potato Crisps", 3.05);

        logMessageTestExpected = (ReportsAndLogging.getTimeForLog() + "  " + logMessageToTest);
        Assertions.assertEquals(logMessageTestExpected, logMessageTestActual);
    }



    @Test
    void loggingTest() {
        ReportsAndLogging logTest = new ReportsAndLogging();
        String testTimeForLog = "";
        String logStatement = "";
        String message = "Test Message";
        String logStatementTest = (ReportsAndLogging.getTimeForLog() + "  " + message);

        testTimeForLog = ReportsAndLogging.getTimeForLog();
        logStatement = ReportsAndLogging.log(message);

        assertEquals(logStatementTest, ReportsAndLogging.log(message));


    }
}
