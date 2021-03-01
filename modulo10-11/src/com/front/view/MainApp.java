package com.front.view;

//import com.front.domain.Window;
import com.crud.controller.BusinessController;
import com.crud.controller.BusinessController.Color;
import com.crud.controller.BusinessController.Material;

import com.front.domain.*;

@SuppressWarnings("unused") // for console tests
public abstract class MainApp {

	public static void main(String[] args) {
		Panel w = new Panel();
		w.setVisible(true);
		
		//CONSOLE TESTS AVAIBLE
		//controller instance
		BusinessController c = new BusinessController();
		//create stores
		c.createFlowerShop("Petalon");
		c.createFlowerShop("McQueens");
		//read stores. empty
		c.getAllFlowerShops().forEach(System.out::println);		
		//create flower
		c.createFlower("Rose", Color.Red, 7.5, "1");
		c.createFlower("Rose", Color.Yellow, 7.5, "Petalon");
		c.createFlower("Daisy", Color.Blue, 3.5, "petalon");
		c.createFlower("Sunflower", Color.Yellow, 6.5, "1");
		c.createFlower("Sunflower", Color.Yellow, 6.5, "mcqueens");
		c.createFlower("Alstroemerias", Color.Yellow, 9, "2");
		//create tree		
		c.createTree("Oak", 1.5, 75.50, "PETALON");
		c.createTree("Orange Tree", 1.3, 55.0, "1");
		c.createTree("Lemon Tree", 1.1, 45.0, "2");
		//create decoration
		c.createDecoration("Box", Material.Wood, 12.5, "1");		
		c.createDecoration("Vase", Material.Plastic, 10.0, "petALON");
		//create decoration. error. store not found	
		c.createDecoration("Gift Lace", Material.Plastic, 7.50, "one");						
		//read stores. completed
		c.getAllFlowerShops().forEach(System.out::println);		
		//read stock. error. store not found
		c.showStock("two");		
		//read stock
		c.showStock("1");
		c.showStock("2");
	}
}