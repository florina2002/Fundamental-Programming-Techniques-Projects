package org.example.Presentation.OrderPackage;

import org.example.DataAccess.OrderDAO;
import org.example.Model.Order;
import org.example.Presentation.OrderPackage.OrderView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddOrder extends JDialog {
    private JTextField orderID;
    private JTextField clientID;
    private JTextField productID;
    private JTextField orderQuantity;
    private JButton addOrderButton;
    private JButton backButton;
    private JPanel panel;

    private static final Logger LOGGER = Logger.getLogger(AddOrder.class.getName());

    public AddOrder(JFrame parent) {
        super(parent);
        setTitle("AddOrder");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Retrieve input values from text fields
                int orderId = Integer.parseInt(orderID.getText());
                int clientId = Integer.parseInt(clientID.getText());
                int productId = Integer.parseInt(productID.getText());
                int quantity = Integer.parseInt(orderQuantity.getText());

                // Create Order object
                Order order = new Order();
                order.setOrderid(orderId);
                order.setClientid(clientId);
                order.setProductid(productId);
                order.setQuantity(quantity);

                // Insert order into the database
                OrderDAO orderDAO = new OrderDAO();
                Order insertedOrder = orderDAO.insert(order);
                if (insertedOrder != null) {
                    LOGGER.info("Order added successfully.");
                    dispose();
                    OrderView orderView = new OrderView(null);
                } else {
                    LOGGER.warning("Failed to add the order.");
                }
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
