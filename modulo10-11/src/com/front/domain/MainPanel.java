package com.front.domain;



import com.crud.controller.BusinessController;

import com.front.utilities.Inputs;

import javax.swing.*;
import java.awt.event.*;


//main panel class which will control the creation of new flower shops

public class MainPanel extends JPanel {

    //Atribites and buttons
    private final BusinessController bC = new BusinessController();
    JButton createNewShop, closeWindows;
    static JTextField shopNameField;
    String newShopName;
    //Every new window will have a different name and number
    private static int counter = 0;

    //Main panel constructor.
    public MainPanel() {
        initComponents();
    }

    private void initComponents() {
        createNewShop = new JButton("Create new shop!");
        add(createNewShop);
        closeWindows = new JButton("Close all shops");
        add(closeWindows);

        //we now set the newShop button as an event performer using que listener class from below
        NewShopListener newShopListener = new NewShopListener();
        createNewShop.addActionListener(newShopListener);
      //-------------------------------------------------

        shopNameField = new JTextField(25);
        add(shopNameField);
        shopNameField.setText("Insert shop's name");

        //we now set methods to manage the "insert shop's name" text
        //1. here we erease the text as soon as we start writing a new name
        shopNameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shopNameField.setText("");
            }
        });

        //2. here we set the newShopName and reset again the original "insert name" text when clicking on create shop
        createNewShop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == createNewShop) {
                    bC.createFlowerShop(Inputs.toTitleCase(newShopName));
                    System.out.println("Business with name: " + newShopName + " successfully created");
                }
                if (!shopNameField.equals("Insert shop's name")) {
                    newShopName = shopNameField.getText();
                    shopNameField.setText("Insert shop's name");
                }
            }
        });
    }

    //private and internal Listener class implementing ActionListener,
    //which will call secondaryPanel when clicking on button.
    private class NewShopListener extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            //this will add a name to the new shop and allow to close all secondary windows
            SecondaryPanel newShopFrame = new SecondaryPanel(newShopName, closeWindows);
        }
    }
}

