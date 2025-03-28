package org.example.Presentation.ProductPackage;

import org.example.DataAccess.ProductDAO;
import org.example.Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteProduct extends JDialog {
    private JTextField productID;
    private JButton deleteProductButton;
    private JButton backButton;
    private JPanel panel;

    private static final Logger LOGGER = Logger.getLogger(DeleteProduct.class.getName());
    private ProductDAO productDAO;

    public DeleteProduct(JFrame parent) {
        super(parent);
        setTitle("DeleteProduct");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        productDAO = new ProductDAO();
        deleteProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Retrieve product ID from the text field
                int productId = Integer.parseInt(productID.getText());

                // Create a Product object with the ID
                Product product = new Product();
                product.setProductid(productId);

                // Delete the product from the database
                boolean isDeleted = productDAO.delete(product);

                if (isDeleted) {
                    // Show a success message
                    JOptionPane.showMessageDialog(DeleteProduct.this, "Product deleted successfully.");
                    dispose();
                    ProductView productView = new ProductView(null);
                } else {
                    // Show an error message
                    JOptionPane.showMessageDialog(DeleteProduct.this, "Failed to delete the product.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Clear the text field
                productID.setText("");
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
