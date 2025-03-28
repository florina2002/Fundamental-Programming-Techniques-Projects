package org.example.Presentation.ClientPackage;

import org.example.DataAccess.ClientDAO;
import org.example.Model.Client;
import org.example.Presentation.ClientController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteClient extends JDialog{
    private JButton deleteClientButton;
    private JTextField clientID;
    private JButton backButton;
    private JPanel panel;
    private ClientController clientController;

    private ClientDAO clientDAO;

    public DeleteClient(JFrame parent) {
        super(parent);
        setTitle("DeleteClient");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        clientController = new ClientController();

        clientDAO = new ClientDAO();

        deleteClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int clientId = Integer.parseInt(clientID.getText());

                // Create a new Client object
                Client client = new Client();
                client.setClientid(clientId);

                // Call the delete method in the ClientDAO
                boolean isDeleted = clientDAO.delete(client);

                if (isDeleted) {
                    JOptionPane.showMessageDialog(null, "Client deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete the client.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                dispose();
                DeleteClient deleteClient = new DeleteClient(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                ClientView clientView = new ClientView(null);
            }
        });

        setVisible(true);

        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                ClientView clientView = new ClientView(null);
            }
        });

        setVisible(true);
    }
}
