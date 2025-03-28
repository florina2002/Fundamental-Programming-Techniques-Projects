package org.example.Presentation.ProductPackage;

import org.example.Presentation.OrdersManagementMainView;

import javax.swing.*;

public class ProductView extends JDialog{
    private JButton addProductButton;
    private JButton deleteProductButton;
    private JButton editProductButton;
    private JButton showAllProductsButton;
    private JButton backButton;
    private JPanel panel;

    public ProductView(JFrame parent) {
        super(parent);
        setTitle("ProductView");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                AddProduct addProduct = new AddProduct(null);
            }
        });

        deleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                DeleteProduct deleteProduct = new DeleteProduct(null);
            }
        });

        editProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                EditProduct editProduct = new EditProduct(null);
            }
        });

        showAllProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                ShowAllProducts showAllProducts = new ShowAllProducts(null);
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
