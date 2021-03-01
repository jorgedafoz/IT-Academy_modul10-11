package com.crud.domain;

public abstract class Product {

	private String name;
    private double price;
    private int id;
    private static int counterId = 1;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
        id = counterId;
        Product.counterId++;
    }
    
    public int getId() {
    	return id;
    }

    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}