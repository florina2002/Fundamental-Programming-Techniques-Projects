package org.example.Model;

/**
 * The `Order` class represents an order entity.
 */
public class Order {
    private int orderid;
    private int clientid;
    private int productid;
    private int quantity;

    /**
     * Constructs an empty `Order` object.
     */
    public Order() {
    }

    /**
     * Constructs an `Order` object with the specified order ID, client ID, product ID, and quantity.
     *
     * @param orderid the order ID
     * @param clientid the client ID associated with the order
     * @param productid the product ID associated with the order
     * @param quantity the quantity of the product in the order
     */
    public Order(int orderid, int clientid, int productid, int quantity) {
        this.orderid = orderid;
        this.clientid = clientid;
        this.productid = productid;
        this.quantity = quantity;
    }

    /**
     * Retrieves the order ID.
     *
     * @return the order ID
     */
    public int getOrderid() {
        return orderid;
    }

    /**
     * Sets the order ID.
     *
     * @param orderid the order ID to set
     */
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    /**
     * Retrieves the client ID associated with the order.
     *
     * @return the client ID
     */
    public int getClientid() {
        return clientid;
    }

    /**
     * Sets the client ID associated with the order.
     *
     * @param clientid the client ID to set
     */
    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    /**
     * Retrieves the product ID associated with the order.
     *
     * @return the product ID
     */
    public int getProductid() {
        return productid;
    }

    /**
     * Sets the product ID associated with the order.
     *
     * @param productid the product ID to set
     */
    public void setProductid(int productid) {
        this.productid = productid;
    }

    /**
     * Retrieves the quantity of the product in the order.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the order.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
