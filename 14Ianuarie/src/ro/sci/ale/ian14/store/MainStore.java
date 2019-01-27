package ro.sci.ale.ian14.store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this class implements an application which simulates the operations at a store
 * based on the user choose can add, create, sell product, display daily sells and exist program.
 *
 * @author Alexandra Buda
 */
public class MainStore {
    static List<AnimalProduct> animalList = new ArrayList<AnimalProduct>();
    static List<VegetableProduct> vegetableProductList = new ArrayList<VegetableProduct>();
    static List<Product> sellList = new ArrayList<Product>();

    static Scanner scan = new Scanner(System.in);

    /**
     * main method which makes use of addProduct(), printList(),sellProduct(),
     * showSellListRepot() methods and  display the main menu
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        addAvaialbleProducts();
        int userChoice;
        boolean quit = false;

        do {
            System.out.println("\n1. Create product and add it to stock."
                    + "\n2. Sell product."
                    + "\n3. Display daily sales report"
                    + "\n4. Exit"
                    + "\nChoose an option: ");

            userChoice = scan.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Choose product type (1 - animal; 2 - vegetable): ");
                    int answer = scan.nextInt();
                    switch (answer) {
                        case 1:
                            addProduct("1");
                            break;
                        case 2:
                            addProduct("2");
                            break;
                        default:
                            System.out.println("\nInvalid Choice");
                    }

                    break;

                case 2:
                    printList();
                    sellProduct();

                    break;

                case 3:
                    System.out.println(LocalDate.now());
                    showSellListRepot();
                    break;

                case 4:
                    System.out.println("Thanks ");
                    quit = true;
                    break;

                default:
                    System.out.println("\nInvalid Choice");
            }
        }
        while (!quit);
    }

    /**
     * method to input a new product with all the details and add it to the list of products
     *
     * @param productType - the type of product: animal or vegetable
     */
    private static void addProduct(String productType) {
        String name;
        int productID;
        double price;
        String validityDate;
        double weight;
        int quantity;
        int storageTemp;
        String vitaminsList;

        System.out.println("Enter name: ");
        name = scan.next();

        System.out.println("Enter price in LEI: ");
        price = scan.nextDouble();

        System.out.println("Enter validityDate in format: YYYY-MM-DD ");
        validityDate = scan.next();

        System.out.println("Enter weight: ");
        weight = scan.nextDouble();

        System.out.println("Enter quantity: ");
        quantity = scan.nextInt();

        if (productType.equals("1")) {
            System.out.println("Enter storage temperature: ");
            storageTemp = scan.nextInt();

            productID = animalList.size() + vegetableProductList.size();

            AnimalProduct animal = new AnimalProduct(name, productID, price, validityDate,
                    weight, quantity, storageTemp);
            animalList.add(animal);

            System.out.println(animal.getProductID());

        } else {
            System.out.println("Enter vitamin list: ");
            vitaminsList = scan.nextLine();

            productID = vegetableProductList.size() + animalList.size();
            VegetableProduct vegetable = new VegetableProduct(name, productID, price, validityDate,
                    weight, quantity, vitaminsList);
            vegetableProductList.add(vegetable);
        }
    }

    /**
     * method to sell a product based on the id and quantity given by the user
     *
     */
    public static void sellProduct() {
        System.out.println("Please insert product Id: ");
        String id = scan.next();

        int quantity;
        int i = 0;

        for (Product x : animalList) {
            if (x.getProductID() == Integer.parseInt(id)) {
                System.out.println("Please insert the quantity for the animal product: ");
                quantity = scan.nextInt();
                i = 1;
                if (quantity <= x.getQuantity()) {
                    x.setQuantity(x.getQuantity() - quantity);
                    sellListReport(x.getProductID(), quantity);
                } else {
                    System.out.println("Quantity is not available");
                }
            }
        }

        for (Product y : vegetableProductList) {
            if (y.getProductID() == Integer.parseInt(id)) {
                System.out.println("Please insert the quantity for the vegetable product: ");
                quantity = scan.nextInt();
                i = 1;
                if (quantity <= y.getQuantity()) {
                    y.setQuantity(y.getQuantity() - quantity);
                    sellListReport(y.getProductID(), quantity);
                } else {
                    System.out.println("Quantity is not available");
                }
            }
        }

        if (i == 0) {
            System.out.println("Invalid selection");
            sellProduct();
        }
    }

    /**
     * method to assign values
     *
     */
    public static void addAvaialbleProducts() {
        AnimalProduct milk = new AnimalProduct("milk", 0, 10,
                                                            "01.05.2019", 1,
                                                                            200, 5);
        animalList.add(milk);
        AnimalProduct egg = new AnimalProduct("egg", 1, 2,
                                                            "01.05.2019", 0.1,
                                                                            500, 5);
        animalList.add(egg);

        VegetableProduct cabbage = new VegetableProduct("cabbage", 2, 3,
                                                              "01.03.2019", 0.5,
                                                                      100, "C,A,K");
        vegetableProductList.add(cabbage);
    }

    /**
     * method to display the existing list of products
     */
    private static void printList() {
        int i = 1;
        for (Product x : animalList) {
            System.out.println(i + ". " + x.getName() + " ID " + x.getProductID() + " quantity " + x.getQuantity());
            i++;
        }
        for (Product x : vegetableProductList) {
            System.out.println(i + ". " + x.getName() + " ID " + x.getProductID() + " quantity " + x.getQuantity());
            i++;
        }
    }

    /**
     * method to add the id and the quantity of the product in sell list
     *
     * @param id - product ID that will be sell
     * @param qty - the quantity that will be sell
     */
    private static void sellListReport(int id, int qty) {
        Product myProduct = new Product(id, qty);
        sellList.add(myProduct);
    }

    /**
     * method to display all the orders from the date chosen by the user
     *
     */
    private static void showSellListRepot() {
        System.out.println("Insert the date in format: YYYY-MM-DD");
        String date = scan.next();
        for (Product x : sellList) {
            if (x.getSellDate().equals(LocalDate.parse(date)))
                System.out.println("Product ID: " + x.getProductID() + " quantity " + x.getQuantity());
        }
    }
}
