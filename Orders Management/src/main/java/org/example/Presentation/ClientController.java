package org.example.Presentation;

import org.example.DataAccess.ClientDAO;
import org.example.Model.Client;

public class ClientController {
    private ClientDAO clientDAO;

    public ClientController() {
        clientDAO = new ClientDAO();
    }

    public void addClient(int clientID, String clientName, int clientAge, String clientAddress, String clientEmail) {
        // Create a new Client object and set its properties
        Client client = new Client();
        client.setClientid(clientID);
        client.setName(clientName);
        client.setAge(clientAge);
        client.setAddress(clientAddress);
        client.setEmail(clientEmail);

        // Call the insert method in the ClientDAO to add the client to the database
        clientDAO.insert(client);

        // Optionally, you can add additional logic here, such as displaying a success message or refreshing the client view
    }

}
