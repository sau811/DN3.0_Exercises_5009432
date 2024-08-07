import java.util.Arrays;
import java.util.Random;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class SortingCustomerOrders {

    
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10;  
        Order[] orders = new Order[n];

        
        for (int i = 0; i < n; i++) {
            orders[i] = new Order(i + 1, "Customer" + (i + 1), rand.nextDouble() * 1000);
        }

        
        System.out.println("Unsorted Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        long startTime = System.nanoTime();
        bubbleSort(bubbleSortedOrders);
        long endTime = System.nanoTime();
        System.out.println("\nOrders Sorted with Bubble Sort:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }
        System.out.println("Bubble Sort Time (ns): " + (endTime - startTime));

        
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        startTime = System.nanoTime();
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        endTime = System.nanoTime();
        System.out.println("\nOrders Sorted with Quick Sort:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
        System.out.println("Quick Sort Time (ns): " + (endTime - startTime));

        
        System.out.println("\nBubble Sort Time Complexity: O(n²)");
        System.out.println("Quick Sort Time Complexity: O(n log n) on average");
        System.out.println("Quick Sort is generally preferred over Bubble Sort due to its faster average performance, especially with larger datasets.");
    }
}
