package com.crud.domain;

public class Decoration extends Product {

    private String material;
    
    public Decoration(String name, String material, double price){
    	super(name, price);
    	this.material = material;
    }

	public String getWoodOrPlastic() {
		return material;
	}

	public void setWoodOrPlastic(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Decoration [" + "ID=" + getId() + ", Name=" + getName() + ", Material=" + material + ", Price=" + getPrice() + "]";
	}
    
}