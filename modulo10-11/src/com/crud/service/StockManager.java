package com.crud.service;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.crud.persistence.ShopsRepository;

import com.crud.domain.FlowerShop;
import com.crud.domain.Decoration;
import com.crud.domain.Flower;
import com.crud.domain.Product;
import com.crud.domain.Tree;

public final class StockManager {

	private final ShopsRepository repository = new ShopsRepository();

	//constructor
	public StockManager() {
	}

	//create store
	public void createFlowerShop(String newShopName) {
		repository.addFlowerShop(Factory.createFlowerShop(newShopName));
	}
	
	//get all stores
	public List<FlowerShop> getAllFlowerShops() {
		return repository.getAllFlowerShops();
	}
	
	//find 1 store
	public FlowerShop findFlowerShop(String Store) {
		FlowerShop store = null;													//instantiates the variable to be returned
		try {																		//try
			Stream<FlowerShop> s = repository.getAllFlowerShops().stream();			//instantiate a stream from the database list
			s = (Store.chars().allMatch(Character::isDigit))						//ternary checks whether the string entered with only numbers
					? s.filter(b -> b.getId() == Integer.parseInt(Store))			//true: search store by id code
							: s.filter(b -> b.getName().equalsIgnoreCase(Store));	//false: true: search store by name
			store = s.findFirst().get();											//assigns the store the variable that will be returned
		} catch (Exception e) {														//catch
		System.out.println("NoSuchElementException: Store not found!");				//print the error
		}
		return store;
	}

	//create decoration and add to a store
	public void createDecoration(String name, String material, double price, String Store) {
		FlowerShop store = findFlowerShop(Store);
		if (store != null) {
			store.addStock(Factory.createDecoration(name, material, price));
		}
	}

	//create flower and add to a store
	public void createFlower(String name, String color, double price, String Store) {
		FlowerShop store = findFlowerShop(Store);
		if (store != null) {
			store.addStock(Factory.createFlower(name, color, price));
		}
	}

	//create a tree and add to a store
	public void createTree(String name, double height, double price, String Store) {
		FlowerShop store = findFlowerShop(Store);
		if (store != null) {
			store.addStock(Factory.createTree(name, height, price));
		}
	}

	//read stock
	public void showStock(String Store) {
		FlowerShop store = findFlowerShop(Store);											//store instance
		if (store !=  null) {															//check if not null
			System.out.println("\n_________________________________________________________\n");//header printing
			
			System.out.println("Stock of " + store.getName() + 							//header printing
					" | Total amount Items: " + store.getStock().size());
			
			printTypeStock("Flowers", store, new Flower("", "", 0));						//product stock printing flowers
			printTypeStock("Tree", store, new Tree("", 0, 0));								//product stock printing trees
			printTypeStock("Decoration", store, new Decoration("", "", 0));					//product stock printing decoration
			
			System.out.println("\n_________________________________________________________\n");//footer printing
		}
	}
	
	//print stock
	private void printTypeStock(String type, FlowerShop store, Product item) {
		List<Product> stock = store.getStock().stream()				//list from the store object stream
				.filter(x -> x.getClass().equals(item.getClass()))			//stock filtering from the item class
				.collect(Collectors.toList());								//string to list conversion
		System.out.println("\n" + type + ": " + stock.size() + " items");	//header print
		stock.forEach(System.out::println);									//stock print
	}

	//internal private class. object factory
	private static class Factory {

		static FlowerShop createFlowerShop(String name) {
			return new FlowerShop(name);
		}

		static Decoration createDecoration(String name, String material, double price) {
			return new Decoration(name, material, price);
		}

		static Flower createFlower(String name, String colour, double price) {
			return new Flower(name, colour, price);
		}

		static Tree createTree(String name, double height, double price) {
			return new Tree(name, height, price);
		}
	}
}