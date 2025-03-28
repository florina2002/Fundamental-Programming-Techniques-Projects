package org.example.Presentation.ProductPackage;

import org.example.DataAccess.ProductDAO;
import org.example.Model.Product;
import org.example.Presentation.ProductPackage.ProductView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddProduct extends JDialog {
    private JTextField productID;
    private JTextField productName;
    private JTextField productPrice;
    private JButton addProductButton;
    private JTextField productStock;
    private JButton backButton;
    private JPanel panel;

    private static final Logger LOGGER = Logger.getLogger(AddProduct.class.getName());

    public AddProduct(JFrame parent) {
        super(parent);
        setTitle("AddProduct");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Retrieve product information from text fields
                int productId = Integer.parseInt(productID.getText());
                String productName = AddProduct.this.productName.getText();
                int productPrice = Integer.parseInt(AddProduct.this.productPrice.getText());
                int productStock = Integer.parseInt(AddProduct.this.productStock.getText());

                // Create a new Product object
                Product product = new Product();
                product.setProductid(productId);
                product.setProductname(productName);
                product.setProductprice(productPrice);
                product.setProductstock(productStock);

                // Insert the product into the database
                ProductDAO productDAO = new ProductDAO();
                productDAO.insert(product);

                // Show a success message
                JOptionPane.showMessageDialog(AddProduct.this, "Product added successfully.");

                // Clear the text fields
                clearTextFields();

                dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                ProductView productView = new ProductView(null);
            }
        });

        setVisible(true);
    }

    private void clearTextFields() {
        productID.setText("");
        productName.setText("");
        productPrice.setText("");
        productStock.setText("");
    }
}
