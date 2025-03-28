package org.example.Presentation.ClientPackage;

import org.example.Presentation.OrdersManagementMainView;

import javax.swing.*;

public class ClientView extends JDialog{
    private JButton addClientButton;
    private JButton deleteClientButton;
    private JButton editClientButton;
    private JButton showAllClientsButton;
    private JButton backButton;
    private JPanel panel;

    public ClientView(JFrame parent) {
        super(parent);
        setTitle("ClientView");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                AddClient addClient = new AddClient(null);
            }
        });

        deleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                DeleteClient deleteClient = new DeleteClient(null);
            }
        });

        editClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                EditClient editClient = new EditClient(null);
            }
        });

        showAllClientsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                ShowAllClients showAllClients = new ShowAllClients(null);
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
