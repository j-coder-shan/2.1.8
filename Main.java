import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    static productList List;
    static int size;
    static double electronicSales;

    private static void loadData() {
        scan = new Scanner(System.in);

        System.out.println("Enter the No of products :");
        size = scan.nextInt();

        List = new productList(size);

        for (int i = 0; i < size; i++) {
            scan.nextLine();
            System.out.println("--- Product : " + (i+1));

            System.out.println("Enter Product ID :");
            String productID = scan.nextLine();

            System.out.println("Enter Product Name :");
            String productName = scan.nextLine();

            System.out.println("Enter Product category :");
            String category = scan.nextLine();

            System.out.println("Enter Product Price :");
            double unitPrice = scan.nextDouble();

            System.out.println("Enter Product Quantity :");
            int quantity = scan.nextInt();
            scan.nextLine();

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

            Product product = new Product(productID, productName, category, unitPrice, quantity);

            List.insertLast(product);
        }
    }

    private static void changeData() {
        System.out.println("Enter Product Name, Which you want to change :");
        String item = scan.nextLine();

        Product product;

        boolean productFound = false;
        for (int i = 0; i < List.size; i++) {
            product = List.retrieve(i);
            if (product.productName.equalsIgnoreCase(item)) {
                productFound = true;
                System.out.println("Enter Product attribute, Which you want to change :(Product Id / Product Name / Category / Unit Price / Quantity)");
                String itemAttribute = scan.nextLine();
                if (itemAttribute.equalsIgnoreCase("Product Id")) {
                    System.out.println("Enter the new Product Id of " + item + " :");
                    product.productID = scan.nextLine();

                } else if (itemAttribute.trim().equalsIgnoreCase("Product Name")) {
                    System.out.println("Enter the new Product name of " + item + " :");
                    product.productName = scan.nextLine();

                } else if (itemAttribute.trim().equalsIgnoreCase("Category")) {
                    System.out.println("Enter the new Category of " + item + " :");
                    product.category = scan.nextLine();

                } else if (itemAttribute.trim().equalsIgnoreCase("Unit Price")) {
                    System.out.println("Enter the new Unit Price " + item + " :");
                    product.unitPrice = scan.nextDouble();
                    product.salesAmount = product.unitPrice * product.quantity;

                } else if (itemAttribute.trim().equalsIgnoreCase("Quantity")) {
                    System.out.println("Enter the new Quantity of " + item + " :");
                    product.quantity = scan.nextInt();
                    product.salesAmount = product.unitPrice * product.quantity;

                } else {
                    System.out.println("Incorrect product attribute !");
                }
                break;
            }
        }
        if (!productFound) {
            System.out.println("Entered Product is not in the list !");
        }
    }

    private static void topSales() {
        System.out.println("Enter the minimum Sale amount to display sales details :");
        double salesAmount = scan.nextDouble();

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Sales Above " + Math.round(salesAmount * 100.0) / 100.0);
        System.out.printf("%-20s %-20s %-20s%n", "Product ID", "Product Name", "Sales Amount");
        for (int i = 0; i < List.size; i++) {
            Product product = List.retrieve(i);
            if(product.salesAmount > salesAmount){
                System.out.printf("%-20s %-20s %-20s%n", product.productID, product.productName, product.salesAmount);
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void electronicSale() {
        electronicSales = 0;
        System.out.println("Electronics Sales :");
        System.out.printf("%-20s %-20s %-20s%n", "Product ID", "Category", "Sales Amount");
        for (int i = 0; i < List.size; i++) {
            Product product = List.retrieve(i);
            if(product.category.equalsIgnoreCase("Electronics")){
                electronicSales += product.salesAmount;
                System.out.printf("%-20s %-20s %-20s%n", product.productID, product.category, product.salesAmount);
            }
        }
        System.out.println("Total sales of Electronics Items :" + electronicSales);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void electronicSalePercentage() {
        double totalSale = 0;
        for (int i = 0; i < List.size; i++) {
            Product product = List.retrieve(i);
            totalSale += product.salesAmount;
        }
        System.out.println("Total sales of Electronics Items as a percentage of total sale :" + Math.round((electronicSales / totalSale) * 100 * 100.0) / 100.0 + "%");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        loadData();
        List.traverse("Initial Data :");

        selectionSort sortList = new selectionSort();
        sortList.sort(List);
        List.traverse("Sorted Data :");

        changeData();

        topSales();

        electronicSale();

        electronicSalePercentage();
    }




}
