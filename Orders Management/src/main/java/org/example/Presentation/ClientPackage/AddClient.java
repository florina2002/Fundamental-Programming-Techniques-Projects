package org.example.Presentation.ClientPackage;

import org.example.Presentation.ClientController;

import javax.swing.*;

public class AddClient extends JDialog{
    private JTextField clientID;
    private JTextField clientName;
    private JTextField clientAge;
    private JTextField clientAddress;
    private JTextField clientEmail;
    private JButton addClientButton;
    private JButton backButton;
    private JPanel panel;
    private ClientController clientController;

    public AddClient(JFrame parent) {
        super(parent);
        setTitle("AddClient");
        setContentPane(panel);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        clientController = new ClientController();

        addClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Get the input values from the text fields
                int clientId = Integer.parseInt(clientID.getText());
                String name = clientName.getText();
                int age = Integer.parseInt(clientAge.getText());
                String address = clientAddress.getText();
                String email = clientEmail.getText();

                // Call the addClient method in the ClientController
                clientController.addClient(clientId,name, age, address, email);

                dispose();
            }
        });


        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                ClientView clientView = new ClientView(null);
            }
        });

        setVisible(true);
    }
}
