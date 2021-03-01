package com.crud.persistence;

import com.crud.domain.FlowerShop;

import java.util.ArrayList;
import java.util.List;

public final class ShopsRepository {

	private static List<FlowerShop> stores;

	public ShopsRepository() {
		stores = new ArrayList<>();
	}

	public List<FlowerShop> getAllFlowerShops() {
		return new ArrayList<>(stores);
	}

	//method that adds a store to the database
	public void addFlowerShop(FlowerShop store) {
		if (store != null) {
			stores.add(store);
		} else {
			System.out.println("Store cannot be created!");
		}
	}
}