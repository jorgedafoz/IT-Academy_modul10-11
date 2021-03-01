package com.front.domain;



import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {

        setTitle("FlowerShops application");
        setBounds(50,50,350,150);
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
        //pack();
    }
}
