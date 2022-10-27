package com.techelevator.Product;

public class Candy extends Product {
    public Candy(String name, Double price) {
        super(name, price);
    }

    @Override
    public String sound() {
        return "Munch, Munch, Yum!";
    }
}
