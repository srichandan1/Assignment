package com.assignment.goodies;

public class Goodies {
    String name;
    int price;

    public Goodies(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return this.name + ": " + this.price;
    }
}


