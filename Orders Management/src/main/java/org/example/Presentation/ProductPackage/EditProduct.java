package org.example.Presentation.ProductPackage;

import org.example.DataAccess.ProductDAO;
import org.example.Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProduct extends JDialog {
    private JTextField productID;
    private JTextField productName;
    private JTextField productPrice;
    private JButton editProductButton;
    private JTextField productStock;
    private JButton backButton;
    private JPanel panel;

    private ProductDAO productDAO;

    public EditProduct(JFrame parent) {
        super(parent);
        setTitle("Edit Product");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        productDAO = new ProductDAO();

        editProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Get the input values from the text fields
                int productId = Integer.parseInt(productID.getText());
                String name = productName.getText();
                int price = Integer.parseInt(productPrice.getText());
                int stock = Integer.parseInt(productStock.getText());

                // Create a new Product object
                Product product = new Product();
                product.setProductid(productId);
                product.setProductname(name);
                product.setProductprice(price);
                product.setProductstock(stock);

                // Call the update method in the ProductDAO
                Product updatedProduct = productDAO.update(product);

                if (updatedProduct != null) {
                    JOptionPane.showMessageDialog(null, "Product updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the EditProduct dialog after successful update
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update the product.", "Error", JOptionPane.ERROR_MESSAGE);
                }

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
}
