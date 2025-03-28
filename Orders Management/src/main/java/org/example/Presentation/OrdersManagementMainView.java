package org.example.Presentation;

import org.example.Presentation.ClientPackage.ClientView;
import org.example.Presentation.OrderPackage.OrderView;
import org.example.Presentation.ProductPackage.ProductView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdersManagementMainView extends JDialog{
    private JPanel panel1;
    private JButton clientsButton;
    private JButton productsButton;
    private JButton ordersButton;

    public OrdersManagementMainView(JFrame parent) {
        super(parent);
        setTitle("OrdersManagementMainView");
        setContentPane(panel1);
        setMinimumSize(new Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OrderView orderView = new OrderView(null);
            }
        });

        clientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ClientView client = new ClientView(null);
            }
        });

        productsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ProductView product = new ProductView(null);
            }
        });



        setVisible(true);
    }

    public static void main(String[] args) {
        OrdersManagementMainView ordersManagementMainView = new OrdersManagementMainView(null);
    }
}
