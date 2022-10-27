package com.techelevator;
import com.techelevator.Product.Product;
import com.techelevator.Product.ProductGS;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Map;

public class VendingMachineFunctions {

    private double Total_Sales = 0.00;
    private double currentMoneyProvided = 00.00;
    ProductGS productObj = new ProductGS();
    private Map<String, Product> vendingMachineMap = productObj.buildMenu();
    private int quantity = 0;

    private static final DecimalFormat df = new DecimalFormat("0.00");




    public VendingMachineFunctions() {
    }

    public double addToCustomerAccount(int moneyChoice) {
        switch (moneyChoice) {
            case(1):
                setCurrentMoneyProvided(1.00 + getCurrentMoneyProvided());
                break;
            case (5):
                setCurrentMoneyProvided(5.00 + getCurrentMoneyProvided());
                break;
            case (10):
                setCurrentMoneyProvided(10.00 + getCurrentMoneyProvided());
                break;
        }
        System.out.printf("%s %.2f%n",   "Your Balance is  $", getCurrentMoneyProvided());
        ReportsAndLogging.log("FEED MONEY : $" + df.format((double)moneyChoice) + "  RUNNING BALANCE : $" + df.format(this.getCurrentMoneyProvided()));
    return getCurrentMoneyProvided();
    }

    public String selectProduct(String itemChoiceFromUser)  {
        double productPrice = this.vendingMachineMap.get(itemChoiceFromUser).getPrice();
        double customerBalance = this.getCurrentMoneyProvided();
        String productName = this.vendingMachineMap.get(itemChoiceFromUser).getName();;
        String productType = this.vendingMachineMap.get(itemChoiceFromUser).getClass().getSimpleName();
        String productSound = this.vendingMachineMap.get(itemChoiceFromUser).sound();

        String logMessage = "";

        if (!(this.vendingMachineMap.containsKey(itemChoiceFromUser))) {

            System.out.println("We're sorry, " + itemChoiceFromUser + " is not a valid item ID");
        } else {
            if ((customerBalance - productPrice) < 0 ) {
                insufficientFundsMessage();
            } else if (this.vendingMachineMap.get(itemChoiceFromUser).getQuantity() < 0) {
                outOfStockMessage();
            } else  {
                    logMessage +=  productName + " " + itemChoiceFromUser +    "   $" + df.format(this.getCurrentMoneyProvided());
                    ReportsAndLogging.logMessageBuilder(itemChoiceFromUser, productName, productPrice);
                    this.vendingMachineMap.get(itemChoiceFromUser).reduceQuantity();
                    this.setCurrentMoneyProvided(this.getCurrentMoneyProvided() - productPrice);
                    this.addToTotalSales(productPrice);

                System.out.printf("%s %.2f %s %.2f \n \n %s %s %s %s \n %s",
                "The total for all of your items is: $", this.getTotalSales(),
                "     Your remaining balance is: $", this.getCurrentMoneyProvided(),
                "Dispensing the item: ", productName, "- Enjoy your ", productType, productSound);

                ReportsAndLogging.log( logMessage + "  Updated Customer Balance: $" +df.format(this.getCurrentMoneyProvided()));
            }
        }
        return productType;
    }

    public void finishTransaction() {
        String change = "" + df.format(this.getCurrentMoneyProvided());


        if(!(this.getCurrentMoneyProvided()>=0.05)) {
            System.out.println("We're sorry, insufficient funds.");
        } else {
            Currency my = new Currency();
            my.getChangeInCoins(this.getCurrentMoneyProvided());
            this.setBalanceToZero();
            System.out.println("Thank you for your business!");

            ReportsAndLogging.log("GIVE CHANGE: $" + change + "  RUNNING BALANCE: $" + df.format(this.getCurrentMoneyProvided()));
        }
    }

    public void printSalesReports(){
        ReportsAndLogging.getSalesReports(this.getVendingMachineMap(),this.getTotalSales());
    }

    private void insufficientFundsMessage() {
        System.out.printf("%s %s  %.2f  %s %s",  "\nWe're sorry, you have insufficient funds for this purchase.\n",
        "Your balance is $",getCurrentMoneyProvided(),  " Please insert more cash.  \n \n",
        ".  .  .  \n\nReturning to the Purchase Menu:\n");
    }

    private void outOfStockMessage() {
        System.out.println("We're sorry, insufficient stock for this purchase.  Please choose another item.");
    }

    public void setBalanceToZero() {
        this.currentMoneyProvided = 00.00;
    }

    public void addToTotalSales(double priceToAdd) {
        this.Total_Sales += priceToAdd;
    }

    public double getTotalSales() {
        return this.Total_Sales;
    }

    public Map<String, Product> getVendingMachineMap() {
        return vendingMachineMap;
    }

    public double getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void setCurrentMoneyProvided(double currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }
}




