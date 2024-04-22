class Order {
    private int customerId;
    private int orderId;
    private Product[] products;
    public float totalPrice;

    public Order(int customerId, int orderId, Product[] products) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = products;
        this.totalPrice = calculateTotalPrice();
    }

    public float calculateTotalPrice() {
        float total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        for (Product product : products) {
            if (product != null) {
                System.out.println( product.getName() + " - " + "$" + product.getPrice());
            }
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}