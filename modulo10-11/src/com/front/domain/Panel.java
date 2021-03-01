package com.front.domain;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.crud.controller.BusinessController;
import com.front.utilities.Inputs;

public class Panel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final BusinessController bC = new BusinessController();
	private JButton createFlowerShop, addTree, addFlower, addDeco, showStock;
	static JTextField flowerName, flowerColour, flowerPrice, treeName, treeHeight, treePrice, decoName, decoType,
			decoPrice, flowerShopName;

	//constructor
	public Panel() {
		super();
		configureWindow();
		initializeComponents();
	}

	//configure interface
	private void configureWindow() {
		this.setTitle("Flower Shop Application");
		this.setSize(800, 375);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//initialize
	private void initializeComponents() {

		JLabel stock = new JLabel("");
		createFlowerShop = new JButton("Create Flower Shop");
		addTree = new JButton("Add Tree");
		addFlower = new JButton("Add Flower");
		addDeco = new JButton("Add Decoration");
		showStock = new JButton("Show Stock");
		flowerName = new JTextField(20);
		flowerColour = new JTextField(20);
		flowerPrice = new JTextField(20);
		treeName = new JTextField(20);
		treeHeight = new JTextField(20);
		treePrice = new JTextField(20);
		decoName = new JTextField(20);
		decoType = new JTextField(20);
		decoPrice = new JTextField(20);
		flowerShopName = new JTextField(30);

		stock.setBounds(100, 10, 200, 20);
		createFlowerShop.setBounds(50, 50, 150, 25);
		createFlowerShop.addActionListener(this);
		addFlower.setBounds(50, 100, 150, 25);
		addFlower.addActionListener(this);
		addTree.setBounds(50, 150, 150, 25);
		addTree.addActionListener(this);
		addDeco.setBounds(50, 200, 150, 25);
		addDeco.addActionListener(this);
		showStock.setBounds(50, 250, 150, 25);
		showStock.addActionListener(this);
		flowerName.setBounds(225, 100, 150, 25);
		flowerColour.setBounds(400, 100, 150, 25);
		flowerPrice.setBounds(575, 100, 150, 25);
		treeName.setBounds(225, 150, 150, 25);
		treeHeight.setBounds(400, 150, 150, 25);
		treePrice.setBounds(575, 150, 150, 25);
		decoName.setBounds(225, 200, 150, 25);
		decoType.setBounds(400, 200, 150, 25);
		decoPrice.setBounds(575, 200, 150, 25);
		flowerShopName.setBounds(225, 50, 150, 25);

		this.add(stock);
		this.add(createFlowerShop);
		this.add(addTree);
		this.add(addFlower);
		this.add(addDeco);
		this.add(showStock);
		this.add(flowerName);
		flowerName.setText(" Flower Name");
		this.add(flowerColour);
		flowerColour.setText(" Flower Colour");
		this.add(flowerPrice);
		flowerPrice.setText(" Flower Price");
		this.add(treeName);
		treeName.setText(" Tree Name");
		this.add(treeHeight);
		treeHeight.setText(" Tree Height");
		this.add(treePrice);
		treePrice.setText(" Tree Price");
		this.add(decoName);
		decoName.setText(" Decoration Name");
		this.add(decoType);
		decoType.setText(" Wood/Plastic");
		this.add(decoPrice);
		decoPrice.setText(" Decoration Price");
		this.add(flowerShopName);
		flowerShopName.setText(" Flower Shop Name");
	
	}
	
	//actions
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == createFlowerShop) {
			bC.createFlowerShop(Inputs.toTitleCase(flowerShopName.getText()));
			System.out.println("Business with name: " + flowerShopName.getText() + " successfully created");

		}
		if (e.getSource() == addTree) {
			String treeNameString = Inputs.toTitleCase(treeName.getText()); 
			double treeHeightDouble = Inputs.toDouble(treeHeight.getText());
			double treePriceDouble = Inputs.toDouble(treePrice.getText());
			
			if(treeHeightDouble >= 0 && treePriceDouble >= 0) {
				bC.createTree(treeNameString, treeHeightDouble, treePriceDouble,
						flowerShopName.getText());
				treeHeight.setText("");
				treeName.setText("");
				treePrice.setText("");
				System.out.println("Tree added");
			} else if(treeHeightDouble <= 0 && treePriceDouble >= 0) {
				System.out.println("Height must be numeric characters,\ndecimal separator must be a dot not a comma!");
				treeHeight.setText("");
			}else if(treeHeightDouble >= 0 && treePriceDouble <= 0){
				System.out.println("Value must be numeric characters,\ndecimal separator must be a dot not a comma!");
				treePrice.setText("");
			}else{
				System.out.println("Value and height must be numeric characters,\ndecimal separator must be a dot not a comma!");
				treeHeight.setText("");
				treePrice.setText("");
			}
		}

		if (e.getSource() == addFlower) {
			String flowerNameString = Inputs.toTitleCase(flowerName.getText()); 
			String flowerColourString = Inputs.toTitleCase(flowerColour.getText()); 
			double flowerPriceDouble = Inputs.toDouble(flowerPrice.getText());

			if (Inputs.validColor(flowerColourString) && flowerPriceDouble >= 0) {
				bC.createFlower(flowerNameString, Inputs.toColor(flowerColourString),
						flowerPriceDouble, flowerShopName.getText());
				flowerName.setText("");
				flowerPrice.setText("");
				flowerColour.setText("");
				System.out.println("Flower added");
			} else if(!(Inputs.validColor(flowerColourString)) && flowerPriceDouble >= 0){
				System.out.println("Available colours are Red, Green, Blue, Yellow");
				flowerColour.setText("");
			}else{
				System.out.println("The price value must be numeric characters,\n" +
						"decimal separator must be a dot not a comma!");
				flowerPrice.setText("");
			}
		}

		if (e.getSource() == addDeco) {
			String decoNameString = Inputs.toTitleCase(decoName.getText()); 
			String decoTypeString = Inputs.toTitleCase(decoType.getText());
			double decoPriceDouble = Inputs.toDouble(decoPrice.getText());

			if (Inputs.validMaterial(decoTypeString) && decoPriceDouble >= 0) {
				bC.createDecoration(decoNameString, Inputs.toMaterial(decoTypeString), decoPriceDouble,
						flowerShopName.getText());
				decoType.setText("");
				decoName.setText("");
				decoPrice.setText("");
				System.out.println("Decoration added");
			} else if(!(Inputs.validMaterial(decoNameString)) && decoPriceDouble >= 0){
				System.out.println("Decoration type must be Wood or Plastic");
				decoType.setText("");
			}else{
				System.out.println("The price value must be numeric characters,\n" +
						"decimal separator must be a dot not a comma!");
				decoPrice.setText("");
			}

		}

		if (e.getSource() == showStock) {
			bC.showStock(Inputs.toTitleCase(flowerShopName.getText()));
		}
	}
}