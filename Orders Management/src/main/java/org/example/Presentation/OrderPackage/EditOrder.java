package org.example.Presentation.OrderPackage;

import org.example.DataAccess.OrderDAO;
import org.example.Model.Order;
import org.example.Presentation.OrderPackage.OrderView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditOrder extends JDialog {
    private JTextField orderID;
    private JTextField clientID;
    private JTextField productID;
    private JTextField orderQuantity;
    private JButton editOrderButton;
    private JButton backButton;
    private JPanel panel;

    private static final Logger LOGGER = Logger.getLogger(EditOrder.class.getName());

    public EditOrder(JFrame parent) {
        super(parent);
        setTitle("EditOrder");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        editOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Retrieve order information from text fields
                int orderId = Integer.parseInt(orderID.getText());
                int clientId = Integer.parseInt(clientID.getText());
                int productId = Integer.parseInt(productID.getText());
                int quantity = Integer.parseInt(orderQuantity.getText());

                // Create an Order object with the updated values
                Order order = new Order();
                order.setOrderid(orderId);
                order.setClientid(clientId);
                order.setProductid(productId);
                order.setQuantity(quantity);

                // Update order in the database
                OrderDAO orderDAO = new OrderDAO();
                Order updatedOrder = orderDAO.update(order);
                if (updatedOrder != null) {
                    LOGGER.info("Order updated successfully.");
                    dispose();
                    OrderView orderView = new OrderView(null);
                } else {
                    LOGGER.warning("Failed to update the order.");
                }

                dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                OrderView orderView = new OrderView(null);
            }
        });

        setVisible(true);
    }
}
