public class Product {
    String productID;
    String productName;
    String category;
    double unitPrice;
    int quantity;
    double salesAmount;

    public Product(String productID, String productName, String category, double unitPrice, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.salesAmount = Math.round(unitPrice * quantity * 100.0) / 100.0;
    }
}
