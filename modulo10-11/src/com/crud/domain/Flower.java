package com.crud.domain;

public class Flower extends Product{

    private String color;

    //constructor
    public Flower(String name, String colour, double price){
        super(name, price);
        this.color = colour;
    }

    //Getter and Setter
	public String getColour() {
		return color;
	}

	public void setColour(String colour) {
		this.color = colour;
	}

	@Override
	public String toString() {
		return "Flower [" + "ID=" + getId() + ", Name=" + getName() + ", colour=" + color + ", Price=" + getPrice() + "]";
	}
    
}