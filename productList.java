public class productList {
    static Product[] list;
    int size;
    int position;

    public productList(int size) {
        this.size = size;
        this.list = new Product[size];
        this.position = -1;
    }

    private boolean isEmpty(){
        return position == -1;
    }

    private boolean isFull(){
        return position == size - 1;
    }

    public void insertLast(Product product){
        if (isFull()){
            System.out.println("List is Full !");
        }
        else {
            list[++ position] = product;
        }
    }

    public Product retrieve(int position){
        if (isEmpty()){
            System.out.println("List is Empty !");
            return null;
        }
        else {
            return list[position];
        }
    }

    public void traverse(String str){
        if (isEmpty()){
            System.out.println("List is Empty !");
        }
        else {
            System.out.println(str);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s%-20s%n", "Product Id", "Product Name", "Category", "Unit Price", "Quantity", "Sales Amount");
            for (Product product : list){
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s%n", product.productID, product.productName, product.category, product.unitPrice, product.quantity, product.salesAmount);
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        }
    }


}
