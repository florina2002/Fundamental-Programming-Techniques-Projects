package org.example.Presentation.OrderPackage;

import org.example.DataAccess.OrderDAO;
import org.example.Model.Order;
import org.example.Presentation.OrderPackage.OrderView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowAllOrders extends JDialog {
    private JButton backButton;
    private JPanel panel;
    private JButton showAllOrdersButton;
    private JTable ordersTable;

    private static final Logger LOGGER = Logger.getLogger(ShowAllOrders.class.getName());

    public ShowAllOrders(JFrame parent) {
        super(parent);
        setTitle("ShowAllOrders");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        showAllOrdersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Retrieve all orders from the database
                OrderDAO orderDAO = new OrderDAO();
                List<Order> orders = orderDAO.getAllOrders();

                // Populate the orders table
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Order ID");
                model.addColumn("Client ID");
                model.addColumn("Product ID");
                model.addColumn("Quantity");

                for (Order order : orders) {
                    model.addRow(new Object[]{
                            order.getOrderid(),
                            order.getClientid(),
                            order.getProductid(),
                            order.getQuantity()
                    });
                }

                ordersTable.setModel(model);
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
