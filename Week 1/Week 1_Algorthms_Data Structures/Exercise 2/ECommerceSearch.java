import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class ECommerceSearch {

    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.productId == productId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == productId) {
                return products[mid];
            }

            if (products[mid].productId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();

        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter productId, productName, and category for product " + (i + 1) + ": ");
            int productId = scanner.nextInt();
            String productName = scanner.next();
            String category = scanner.next();
            products[i] = new Product(productId, productName, category);
        }

        System.out.print("Enter productId to search: ");
        int searchProductId = scanner.nextInt();

        // Linear Search
        long startTime = System.nanoTime();
        Product result = linearSearch(products, searchProductId);
        long endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;

        if (result != null) {
            System.out.println("Product found using Linear Search: " + result);
        } else {
            System.out.println("Product not found using Linear Search");
        }

        // Sort products for Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Binary Search
        startTime = System.nanoTime();
        result = binarySearch(products, searchProductId);
        endTime = System.nanoTime();
        long binarySearchTime = endTime - startTime;

        if (result != null) {
            System.out.println("Product found using Binary Search: " + result);
        } else {
            System.out.println("Product not found using Binary Search");
        }

        // Time Complexity Analysis
        System.out.println("Linear Search Time (ns): " + linearSearchTime);
        System.out.println("Binary Search Time (ns): " + binarySearchTime);

        // Discussion
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n)");
        System.out.println("Binary Search is more suitable for the platform due to its faster search performance, provided the product list is sorted.");
    }
}
