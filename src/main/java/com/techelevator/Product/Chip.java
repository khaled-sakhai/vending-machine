package com.techelevator.Product;

public class Chip extends Product {

    public Chip(String name, Double price) {
        super(name, price);
    }

    @Override
    public String sound() {
        return "Crunch, Crunch, Yum!";

    }

}
