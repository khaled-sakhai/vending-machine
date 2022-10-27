package com.techelevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineFunctionsTest {


    @Test
    void assertAddingToCustomerBalance() {
        VendingMachineFunctions vTest = new VendingMachineFunctions();
        double customerMoney = 0.00;

        customerMoney = vTest.addToCustomerAccount(5);
        Assertions.assertEquals(5.00, customerMoney);

        customerMoney = vTest.addToCustomerAccount(10);
        Assertions.assertEquals(15.00, customerMoney);
    }

    @Test
    void assertBuyingProductReducesCustomerBalance() {
        VendingMachineFunctions vTest = new VendingMachineFunctions();
        double customerMoney = 0.00;
        vTest.addToCustomerAccount(5);
        vTest.selectProduct("A1");
        customerMoney = vTest.getCurrentMoneyProvided();
        Assertions.assertEquals(1.95, customerMoney, 0.001);
    }

    @Test
    void selectProductTest() {
        VendingMachineFunctions vTest = new VendingMachineFunctions();
        String productType = "";

        //vTest.selectProduct("A1");
        productType = vTest.selectProduct("A1");
        Assertions.assertEquals("Chip", productType);

        productType = vTest.selectProduct("A1");
        Assertions.assertNotEquals("Drink", productType);
    }

    @Test
    void finishTransactionSetsBalanceToZero() {
        VendingMachineFunctions vTest = new VendingMachineFunctions();
        double customerBalance = 5.00;

        vTest.finishTransaction();

        customerBalance = vTest.getCurrentMoneyProvided();

        Assertions.assertEquals(0.00, customerBalance);
    }
}
