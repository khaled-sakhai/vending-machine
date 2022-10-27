package com.techelevator.Product;

public class Gum extends Product {

    public Gum(String name, Double price) {
        super(name, price);
    }

    @Override
    public String sound() {
        return "Chew, Chew, Yum!";
    }
}
