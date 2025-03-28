package org.example.Presentation.ClientPackage;

import org.example.DataAccess.ClientDAO;
import org.example.Model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowAllClients extends JDialog {
    private JButton backButton;
    private JPanel panel;
    private JTable clientTable;
    private JButton showAllClientsButton;

    private static final Logger LOGGER = Logger.getLogger(ShowAllClients.class.getName());

    public ShowAllClients(JFrame parent) {
        super(parent);
        setTitle("ShowAllClients");
        setContentPane(panel);
        setMinimumSize(new Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                ClientView clientView = new ClientView(null);
            }
        });

        showAllClientsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                populateClientTable();
            }
        });

        setVisible(true);
    }

    private void populateClientTable() {
        // Retrieve all clients from the database
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.findAll();

        // Define table column names
        String[] columnNames = {"Client ID", "Name", "Age", "Address", "Email"};

        // Create table model with column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate the table model with client data
        for (Client client : clients) {
            Object[] rowData = {client.getClientid(), client.getName(), client.getAge(), client.getAddress(), client.getEmail()};
            model.addRow(rowData);
        }

        // Set the table model
        clientTable.setModel(model);
    }
}
