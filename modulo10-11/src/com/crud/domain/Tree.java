package com.crud.domain;

public class Tree extends Product {

    public double height;

    public Tree(String name, double height,double price){
        super(name, price);
        this.height = height;
    }
    
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tree [" + "ID=" + getId() + ", Name=" + getName() + ", Height=" + height + ", Price=" + getPrice() + "]";
	}
    
}