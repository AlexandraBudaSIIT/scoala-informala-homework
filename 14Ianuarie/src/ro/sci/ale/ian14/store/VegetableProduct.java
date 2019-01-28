package ro.sci.ale.ian14.store;

/**
 * this is the subclass which adds one attribute
 *
 * @author Alexandra Buda
 */

public class VegetableProduct extends Product {

    public String vitaminsList;

    public VegetableProduct(String name, int productID, double price, String validityDate, double weight, int quantity, String vitaminsList) {
        super(name, productID, price, validityDate, weight, quantity);
        this.vitaminsList = vitaminsList;
    }
}

