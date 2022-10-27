package com.techelevator;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

public class CurrencyTest{


    @Test
    void assertZeroNickelsReturn() {
        Currency currency = new Currency();
        currency.getChangeInCoins(16.40);
        assertEquals(1, currency.getNumberOfNickels());
    }

    @Test
    void assertMaxTwoDimesReturn() {
        //TODO ARRANGE
        Currency currency = new Currency();
        currency.getChangeInCoins(2.60);
        assertEquals(1, currency.getNumberOfDimes());
    }

    @Test
    void assertQuartersReturn() {
        //TODO ARRANGE
        Currency currency = new Currency();
        currency.getChangeInCoins(75.25);
        assertEquals(301, currency.getNumberOfQuarters());
    }

    @Test
    void assertNoChangeForZeroBalance() {
        //TODO ARRANGE
        Currency currency = new Currency();
        currency.getChangeInCoins(0);
        assertEquals(0, currency.getNumberOfQuarters() + currency.getNumberOfDimes() + currency.getNumberOfNickels());
    }


    @Test
    void assertNoChangeForNegativeBalance() {
        //TODO ARRANGE
        Currency currency = new Currency();
        currency.getChangeInCoins(-5.25);
        assertEquals(0, currency.getNumberOfQuarters() + currency.getNumberOfDimes() + currency.getNumberOfNickels());
    }
}
