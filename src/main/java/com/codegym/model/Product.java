package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String species;

    public Product(){}

    public Product(int id, String name, double price, String species) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}