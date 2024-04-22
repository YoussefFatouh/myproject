import java.util.Scanner;
public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElectronicProduct electronicProduct = new ElectronicProduct(1, "smartphone", 599.99f, "Samsung", 1);
        ClothingProduct clothingProduct = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
        BookProduct bookProduct = new BookProduct(3, "OOP", 39.99f, "O’Reilly", "X Publications");

        System.out.println("Welcome to the E-Commerce System!");
        System.out.println("Please enter your ID:");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your address:");
        String address = scanner.nextLine();

        Customer customer = new Customer(customerId, name, address);

        System.out.println("How many products do you want add to your card ?");
        int nProducts = scanner.nextInt();
        Cart cart = new Cart(customerId, nProducts);
        Order s = new Order(customerId, 1, cart.getProducts());

        for (int i = 0; i < nProducts; i++) {
            System.out.println("which product would you like to add ?" + (i + 1) + ":");
            System.out.println("Enter product type (1: Smartphone, 2: T-Shirt, 3: OOP):");
            int productType = scanner.nextInt();
            scanner.nextLine();

            switch (productType) {
                case 1:
                    cart.addProduct(electronicProduct, i);
                    break;
                case 2:
                    cart.addProduct(clothingProduct, i);
                    break;
                case 3:
                    cart.addProduct(bookProduct, i);
                    break;
                default:
                    System.out.println("Invalid product type.");
            }
        }
        System.out.println("Your total is "+s.calculateTotalPrice()+" Do you want to place an order? 1-Yes  2-No)");
        int response = scanner.nextInt();
        if (response==1) {
            cart.placeOrder();
            Order order = new Order(customerId, 1, cart.getProducts());
            order.printOrderInfo();
        } else if (response==2){
            System.out.println("Order not placed.");
        }

        scanner.close();
    }
}