import java.util.Scanner;

public class FinancialForecasting {

    public static double recursiveFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        return currentValue * (1 + growthRate) * recursiveFutureValue(currentValue, growthRate, periods - 1);
    }

    public static double iterativeFutureValue(double currentValue, double growthRate, int periods) {
        double futureValue = currentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = scanner.nextDouble();

        System.out.print("Enter growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of periods: ");
        int periods = scanner.nextInt();

        long startTime = System.nanoTime();
        double futureValueRecursive = recursiveFutureValue(currentValue, growthRate, periods);
        long endTime = System.nanoTime();
        System.out.println("Future Value (Recursive): " + futureValueRecursive);
        System.out.println("Recursive Method Time (ns): " + (endTime - startTime));

        startTime = System.nanoTime();
        double futureValueIterative = iterativeFutureValue(currentValue, growthRate, periods);
        endTime = System.nanoTime();
        System.out.println("Future Value (Iterative): " + futureValueIterative);
        System.out.println("Iterative Method Time (ns): " + (endTime - startTime));

        scanner.close();
    }
}
