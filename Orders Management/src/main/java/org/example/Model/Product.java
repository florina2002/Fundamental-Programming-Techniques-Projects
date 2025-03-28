package org.example.Model;

/**
 * The `Product` class represents a product entity.
 */
public class Product {
    private int productid;
    private String productname;
    private int productprice;
    private int productstock;

    /**
     * Constructs a `Product` object with the specified product ID, product name, product price, and product stock.
     *
     * @param productid    the product ID
     * @param productname  the product name
     * @param productprice the product price
     * @param productstock the product stock
     */
    public Product(int productid, String productname, int productprice, int productstock) {
        this.productid = productid;
        this.productname = productname;
        this.productprice = productprice;
        this.productstock = productstock;
    }

    /**
     * Constructs an empty `Product` object.
     */
    public Product() {
    }

    /**
     * Retrieves the product ID.
     *
     * @return the product ID
     */
    public int getProductid() {
        return productid;
    }

    /**
     * Sets the product ID.
     *
     * @param productid the product ID to set
     */
    public void setProductid(int productid) {
        this.productid = productid;
    }

    /**
     * Retrieves the product name.
     *
     * @return the product name
     */
    public String getProductname() {
        return productname;
    }

    /**
     * Sets the product name.
     *
     * @param productname the product name to set
     */
    public void setProductname(String productname) {
        this.productname = productname;
    }

    /**
     * Retrieves the product price.
     *
     * @return the product price
     */
    public int getProductprice() {
        return productprice;
    }

    /**
     * Sets the product price.
     *
     * @param productprice the product price to set
     */
    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }

    /**
     * Retrieves the product stock.
     *
     * @return the product stock
     */
    public int getProductstock() {
        return productstock;
    }

    /**
     * Sets the product stock.
     *
     * @param productstock the product stock to set
     */
    public void setProductstock(int productstock) {
        this.productstock = productstock;
    }
}
