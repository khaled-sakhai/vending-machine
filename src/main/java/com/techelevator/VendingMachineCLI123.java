package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;

public class VendingMachineCLI123{
    public static void main(String[] args) throws FileNotFoundException {

      Menu menu = new Menu(System.in, System.out);
        VendingMachineMenus runMainMenu = new VendingMachineMenus(menu);

        runMainMenu.run();

    }
}



