package org.example.Presentation.OrderPackage;

import org.example.Presentation.OrdersManagementMainView;

import javax.swing.*;

public class OrderView extends JDialog{
    private JButton addOrderButton;
    private JButton deleteOrderButton;
    private JButton editOrderButton;
    private JButton showAllOrdersButton;
    private JButton backButton;
    private JPanel panel;

    public OrderView(JFrame parent) {
        super(parent);
        setTitle("OrderView");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                AddOrder addOrder = new AddOrder(null);
            }
        });

        deleteOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                DeleteOrder deleteOrder = new DeleteOrder(null);
            }
        });

        editOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                EditOrder editOrder = new EditOrder(null);
            }
        });

        showAllOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                ShowAllOrders showAllOrders = new ShowAllOrders(null);
            }
        });

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                OrdersManagementMainView ordersManagementMainView = new OrdersManagementMainView(null);
            }
        });

        setVisible(true);
    }
}
