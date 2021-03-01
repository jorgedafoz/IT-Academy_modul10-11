package com.crud.controller;

import com.crud.service.*;
import com.front.domain.MainPanel;

import java.util.List;

public final class BusinessController {

	private final StockManager manager;

	//constructor
	public BusinessController() {
		manager = new StockManager();
	}

	//create store
	public void createFlowerShop(String newShopName) {
		manager.createFlowerShop(newShopName);
	}


	//get all stores
	public List<?> getAllFlowerShops() {
		return manager.getAllFlowerShops();
	}

	//find 1 store
	public Object getFlowerShop(String store) {
		return manager.findFlowerShop(store);
	}

	//create decoration
	public void createDecoration(String name, Material material, double price, String newShopName) {
		manager.createDecoration(name, material.toString(), price, newShopName);
	}

	//create flower
	public void createFlower(String name, Color colour, double price, String newShopName) {
		manager.createFlower(name, colour.toString(), price, newShopName);
	}

	//create tree
	public void createTree(String name, double height, double price, String newShopName) {
		manager.createTree(name, height, price, newShopName);
	}

	//read stock
	public void showStock(String Store) {
		manager.showStock(Store);
	}

	//enum material
	public enum Material {
		Plastic, Wood;
	}

	//enum color
	public enum Color {
		Red, Green, Blue, Yellow;
	}
}