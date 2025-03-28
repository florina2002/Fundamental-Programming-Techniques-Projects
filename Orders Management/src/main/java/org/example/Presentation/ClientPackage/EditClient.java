package org.example.Presentation.ClientPackage;

import org.example.DataAccess.ClientDAO;
import org.example.Model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClient extends JDialog {
    private JTextField clientID;
    private JTextField clientName;
    private JTextField clientAge;
    private JTextField clientAddress;
    private JTextField clientEmail;
    private JButton editClientButton;
    private JButton backButton;
    private JPanel panel;

    private ClientDAO clientDAO;

    public EditClient(JFrame parent) {
        super(parent);
        setTitle("EditClient");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        clientDAO = new ClientDAO();

        editClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Get the input values from the text fields
                int clientId = Integer.parseInt(clientID.getText());
                String name = clientName.getText();
                int age = Integer.parseInt(clientAge.getText());
                String address = clientAddress.getText();
                String email = clientEmail.getText();

                // Create a new Client object
                Client client = new Client();
                client.setClientid(clientId);
                client.setName(name);
                client.setAge(age);
                client.setAddress(address);
                client.setEmail(email);

                // Call the update method in the ClientDAO
                Client updatedClient = clientDAO.update(client);

                if (updatedClient != null) {
                    JOptionPane.showMessageDialog(null, "Client updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the EditClient dialog after successful update
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update the client.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                ClientView clientView = new ClientView(null);
            }
        });

        setVisible(true);
    }
}
