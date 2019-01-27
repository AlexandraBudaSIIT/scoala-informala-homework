package ro.sci.ale.ian14.store;

/**
 *this is the subclass which adds one attribute
 *
 *@author Alexandra Buda
 */
public class AnimalProduct extends Product {
    private int storageTemp;


    public AnimalProduct(String name, int productID, double price, String validityDate, double weight, int quantity, int storageTemp) {
        super(name, productID, price, validityDate, weight, quantity);
        this.storageTemp = storageTemp;
    }

    public int getStorageTemp() {
        return storageTemp;
    }

    public void setStorageTemp(int storageTemp) {
        this.storageTemp = storageTemp;
    }
}

