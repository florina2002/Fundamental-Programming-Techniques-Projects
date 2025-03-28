package org.example.Presentation.ProductPackage;

import org.example.DataAccess.ProductDAO;
import org.example.Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShowAllProducts extends JDialog {
    private JButton backButton;
    private JPanel panel;
    private JButton showAllProductsButton;
    private JTable productsTable;

    public ShowAllProducts(JFrame parent) {
        super(parent);
        setTitle("ShowAllProducts");
        setContentPane(panel);
        setMinimumSize(new Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                ProductView productView = new ProductView(null);
            }
        });

        showAllProductsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayAllProducts();
            }
        });

        setVisible(true);
    }

    private void displayAllProducts() {
        // Create a new ProductDAO instance
        ProductDAO productDAO = new ProductDAO();

        // Retrieve all products
        List<Product> products = productDAO.findAll();

        // Create a table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Product Price");
        tableModel.addColumn("Product Stock");

        // Populate the table model with product data
        for (Product product : products) {
            Object[] rowData = {
                    product.getProductid(),
                    product.getProductname(),
                    product.getProductprice(),
                    product.getProductstock()
            };
            tableModel.addRow(rowData);
        }

        // Set the table model to the productsTable
        productsTable.setModel(tableModel);
    }
}
