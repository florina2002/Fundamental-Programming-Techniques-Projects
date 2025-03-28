package org.example.Presentation.OrderPackage;

import org.example.DataAccess.OrderDAO;
import org.example.Model.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteOrder extends JDialog {
    private JTextField orderID;
    private JButton deleteOrderButton;
    private JButton backButton;
    private JPanel panel;

    private static final Logger LOGGER = Logger.getLogger(DeleteOrder.class.getName());

    public DeleteOrder(JFrame parent) {
        super(parent);
        setTitle("DeleteOrder");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        deleteOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Retrieve order ID from text field
                int orderId = Integer.parseInt(orderID.getText());

                // Create an Order object with the ID
                Order order = new Order();
                order.setOrderid(orderId);

                // Delete order from the database
                OrderDAO orderDAO = new OrderDAO();
                boolean deleted = orderDAO.delete(order);
                if (deleted) {
                    LOGGER.info("Order deleted successfully.");
                    dispose();
                    OrderView orderView = new OrderView(null);
                } else {
                    LOGGER.warning("Failed to delete the order.");
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
