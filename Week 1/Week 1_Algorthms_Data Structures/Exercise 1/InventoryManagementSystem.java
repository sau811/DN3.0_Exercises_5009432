import java.util.Scanner;
import java.util.HashMap;

class InventoryManagementSystem {
    private HashMap<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(id, name, quantity, price);
                    ims.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new Price: ");
                    double newPrice = scanner.nextDouble();
                    ims.updateProduct(updateId, newQuantity, newPrice);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    ims.deleteProduct(deleteId);
                    break;
                case 4:
                    ims.displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}