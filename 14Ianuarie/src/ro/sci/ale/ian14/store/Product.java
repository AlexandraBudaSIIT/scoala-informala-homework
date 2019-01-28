package ro.sci.ale.ian14.store;

import java.time.LocalDate;

/**
 * this is the superclass which has the main attributes of the product
 *
 * @author Alexandra Buda
 */
public class Product {

    private String name;
    private int productID;
    private double price;
    private String validityDate;
    private double weight;
    private int quantity;
    private LocalDate sellDate;

    public Product(String name, int productID, double price, String validityDate, double weight, int quantity) {
        this.name = name;
        this.productID = productID;
        this.price = price;
        this.validityDate = validityDate;
        this.weight = weight;
        this.quantity = quantity;
    }

    public Product(int productID, int quantity) {
        this.sellDate = LocalDate.now();
        this.productID = productID;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

  /*  @Override
    public String toString() {
        return "\nName: " + name + "\nProduct ID: " + productID + "\nPrice: " + price + " lei " +
                "\n Validity Date: " + validityDate + " months " + "\nQuantity: " + quantity + "\n";}*/
    }

