package com.front.domain;

import com.crud.controller.BusinessController;
import com.front.utilities.Inputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import static com.front.domain.MainPanel.shopNameField;

//new windows class for all windows appearing when clicking "create new shop"

public class SecondaryPanel extends JFrame {

    //Every new window will have a different name and number
    private static int counter = 0;
    private final BusinessController bC = new BusinessController();
    private JButton manageButtons, addTree, addFlower, addDeco, showStock;
    static JTextField flowerName, flowerColour, flowerPrice, treeName, treeHeight, treePrice, decoName, decoType,
            decoPrice;

    /* SecondaryPanel contructor.
     * @param receives the MainPanel button closeWindows, so we can close all windows from the mainPanel close button
     * and the newShopName in order to receive the desiredName settet in the mainPanel
     */

    public SecondaryPanel(String newShopName, JButton mainPanelCloseButton) {
        counter++;
        setTitle("Shop " + counter + " " + newShopName);
        //we make sure that every window will appear in a different location
        setBounds(100 * counter, 100 * counter, 500, 500);
        setVisible(true);


        //We create an instance of the Listener class and set the MainPanel close button as the event source.
        closeWindow closeWindowListener = new closeWindow();
        mainPanelCloseButton.addActionListener(closeWindowListener);

        //We initialize all panel components
        initComponents(newShopName);
    }
    private void initComponents(String newShopName) {

        //We create an instance of the Listener class to set all SecondaryPanel buttons as the event source.
        ManageButtons manageButtonListener = new ManageButtons(newShopName);
        manageButtons.addActionListener(manageButtonListener);

        JLabel stock = new JLabel("Wellcome to our flower shop " + newShopName);
        //createFlowerShop = new JButton("Create Business");
        addTree = new JButton("Tree");
        addFlower = new JButton("Flower");
        addDeco = new JButton("Decoration");
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
        //businessName = new JTextField(30);
        stock.setBounds(100, 10, 200, 20);
        //createFlowerShop.setBounds(100, 280, 200, 50);
        //createFlowerShop.addActionListener(this);
        addTree.setBounds(200, 340, 100, 50);
        addTree.addActionListener(manageButtonListener);
        addFlower.setBounds(350, 340, 100, 50);
        addFlower.addActionListener(manageButtonListener);
        addDeco.setBounds(500, 340, 100, 50);
        addDeco.addActionListener(manageButtonListener);
        showStock.setBounds(100, 230, 200, 50);
        showStock.addActionListener(manageButtonListener);
        flowerName.setBounds(350, 390, 60, 20);
        flowerColour.setBounds(410, 390, 60, 20);
        flowerPrice.setBounds(410, 410, 40, 20);
        treeName.setBounds(200, 390, 60, 20);
        treeHeight.setBounds(260, 390, 60, 20);
        treePrice.setBounds(260, 410, 40, 20);
        decoName.setBounds(500, 390, 60, 20);
        decoType.setBounds(560, 390, 60, 20);
        decoPrice.setBounds(560, 410, 40, 20);
        //businessName.setBounds(300, 100, 100, 20);
        this.add(stock);
        //this.add(createFlowerShop);
        this.add(addTree);
        this.add(addFlower);
        this.add(addDeco);
        this.add(showStock);
        this.add(flowerName);
        flowerName.setText("Name");
        this.add(flowerColour);
        flowerColour.setText("Colour");
        this.add(flowerPrice);
        flowerPrice.setText("Price");
        this.add(treeName);
        treeName.setText("Name");
        this.add(treeHeight);
        treeHeight.setText("Height");
        this.add(treePrice);
        treePrice.setText("Price");
        this.add(decoName);
        decoName.setText("Name");
        this.add(decoType);
        decoType.setText("Wood/Plastic");
        this.add(decoPrice);
        decoPrice.setText("Price");
        //this.add(businessName);
        //businessName.setText("Insert name");
    }

    //Private and internat Listener class implementing ActionListener to manage all buttons in SecondaryPanel
    private class ManageButtons implements ActionListener {

        //constructor with newShopName as parameter
        public ManageButtons(String newShopName) {};

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == addTree) {
                String treeNameString = Inputs.toTitleCase(treeName.getText());
                double treeHeightDouble = Inputs.toDouble(treeHeight.getText());
                double treePriceDouble = Inputs.toDouble(treePrice.getText());
                if(treeHeightDouble >= 0 && treePriceDouble >= 0) {
                    bC.createTree(treeNameString, treeHeightDouble, treePriceDouble,
                            shopNameField.getText());
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
                            flowerPriceDouble, shopNameField.getText());
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
                            shopNameField.getText());
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
                bC.showStock(Inputs.toTitleCase(shopNameField.getText()));
            }
        }
    }
    //Private and internal Listener class implementing ActionListener to close windows.
    private class closeWindow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //For window closing we use the dispose() method which inherits from Window and in extension also from JFrame
            dispose();
        }
    }
}






