package com.techelevator;

import com.techelevator.Product.ProductGS;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineMenus {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_EXIT = "Exiting, Thank you.";
    private static final String MAIN_MENU_REPORTS = "generate reports.";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT, MAIN_MENU_REPORTS};
    //private static final String hiddenChoice = "4";

    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String RETURN_TO_MAIN_MENU = "Go back to Main Menu";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION, RETURN_TO_MAIN_MENU};

    private static final String ONE_DOLLAR = "$1.00";
    private static final String FIVE_DOLLARS = "$5.00";
    private static final String TEN_DOLLARS = "$10.00";
    private static final String BACK_TO_PURCHASE_MENU = "Go back to Purchase Menu";
    private static final String[] FEED_MONEY_OPTIONS = {ONE_DOLLAR, FIVE_DOLLARS, TEN_DOLLARS, BACK_TO_PURCHASE_MENU};

    private static final String MORE_MONEY_YES = "Y";
    private static final String MORE_MONEY_NO = "N";

    private String selectedProductButton = "";

    private Menu menu;
    VendingMachineFunctions v1 = new VendingMachineFunctions();
    ProductGS productGS = new ProductGS();
    Scanner input = new Scanner(System.in);
    //PrintStream out = new PrintStream();

    public VendingMachineMenus(Menu menu) {
        this.menu = menu;
    }

    public VendingMachineMenus() {
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                v1.productObj.printSnackChoices();
                // display vending machine items
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                displayPurchaseMenu();
            } else if (choice.equals(MAIN_MENU_EXIT)) {
                System.exit(0);
            } else if (choice.equals(MAIN_MENU_REPORTS)) {
                v1.printSalesReports();
            }
        }
    }

    public void feedMoney() {

        while (true) {
            String feedMenu = (String) menu.getChoiceFromOptionsFeedMoney(FEED_MONEY_OPTIONS);
            if (feedMenu.equals(ONE_DOLLAR)) {
                v1.addToCustomerAccount(1);
            } else if (feedMenu.equals(FIVE_DOLLARS)) {
                v1.addToCustomerAccount(5);
            } else if (feedMenu.equals(TEN_DOLLARS)) {
                v1.addToCustomerAccount(10);
            } else if (feedMenu.equals(BACK_TO_PURCHASE_MENU)) {
                displayPurchaseMenu();
                break;
            }
        }
    }

    public void displayPurchaseMenu() {

        while (true) {
            String purchaseMenu = (String) menu.getChoiceFromOptionsPurchase(PURCHASE_MENU_OPTIONS);
            if (purchaseMenu.equals(PURCHASE_MENU_FEED_MONEY)) {
                feedMoney();
            } else if (purchaseMenu.equals(PURCHASE_MENU_SELECT_PRODUCT)) {

                v1.productObj.printSnackChoices();
                selectedProductButton = input.nextLine().toUpperCase(Locale.ROOT);
                v1.selectProduct(selectedProductButton);

            } else if (purchaseMenu.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
                v1.finishTransaction();
                run();
                v1.printSalesReports();
            } else if (purchaseMenu.equals(RETURN_TO_MAIN_MENU)) {
                run();
            }
        }
        //return purchaseMenu;
    }


    public String menuUserInput(String message) {

        return message;
    }
}
