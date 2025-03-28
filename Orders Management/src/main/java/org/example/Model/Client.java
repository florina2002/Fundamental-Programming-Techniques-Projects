package org.example.Model;

/**
 * The `Client` class represents a client entity.
 */
public class Client {
    private int clientid;
    private String name;
    private String email;
    private int age;
    private String address;

    /**
     * Constructs a `Client` object with the specified client ID, name, email, age, and address.
     *
     * @param clientid the client ID
     * @param name the name of the client
     * @param email the email of the client
     * @param age the age of the client
     * @param address the address of the client
     */
    public Client(int clientid, String name, String email, int age, String address) {
        this.clientid = clientid;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    /**
     * Constructs an empty `Client` object.
     */
    public Client() {
    }

    /**
     * Retrieves the client ID.
     *
     * @return the client ID
     */
    public int getClientid() {
        return clientid;
    }

    /**
     * Sets the client ID.
     *
     * @param clientid the client ID to set
     */
    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    /**
     * Retrieves the name of the client.
     *
     * @return the name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the client.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the email of the client.
     *
     * @return the email of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the client.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the age of the client.
     *
     * @return the age of the client
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the client.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Retrieves the address of the client.
     *
     * @return the address of the client
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the client.
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
