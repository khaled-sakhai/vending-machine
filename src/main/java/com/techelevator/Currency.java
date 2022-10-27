package com.techelevator;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.math.BigDecimal;
public class Currency {

    private static final double NICKEL = (0.05);
    private static final double DIME = (0.10);
    private static final double QUARTER = (0.25);
    private int numberOfQuarters, numberOfDimes, numberOfNickels;
    DecimalFormat rounding = new DecimalFormat(".##");

    //TODO changed return from void to int to test Unit tests
    //double
    public double getChangeInCoins(double balanceFromMachine) {
        balanceFromMachine = balanceFromMachine < 0 ? 0 : balanceFromMachine;
        double roundingBalance = balanceFromMachine;
        numberOfQuarters = (int) (roundingBalance / QUARTER);
        roundingBalance = Double.parseDouble(rounding.format(roundingBalance % QUARTER));

        numberOfDimes = (int) (roundingBalance / DIME);
        roundingBalance = Double.parseDouble(rounding.format(roundingBalance % DIME));

        numberOfNickels = (int) (roundingBalance / NICKEL);
        roundingBalance = Double.parseDouble(rounding.format(roundingBalance % NICKEL));

        System.out.println("Your Change: "+ numberOfQuarters + " Quarter(s), "+ numberOfDimes + " Dime(s), "+numberOfNickels+" Nickel(s).");

        return roundingBalance;
    }

    public int getNumberOfQuarters() {
        return numberOfQuarters;
    }

    public void setNumberOfQuarters(int numberOfQuarters) {
        this.numberOfQuarters = numberOfQuarters;
    }

    public int getNumberOfDimes() {
        return numberOfDimes;
    }

    public void setNumberOfDimes(int numberOfDimes) {
        this.numberOfDimes = numberOfDimes;
    }

    public int getNumberOfNickels() {
        return numberOfNickels;
    }

    public void setNumberOfNickels(int numberOfNickels) {
        this.numberOfNickels = numberOfNickels;
    }
}

