package com.techelevator.Product;

public class Drink extends Product {

    public Drink(String name,Double price) {
        super(name, price);
    }

    @Override
    public String sound(){
       return "Glug, Glug, Yum!";
    }

}
