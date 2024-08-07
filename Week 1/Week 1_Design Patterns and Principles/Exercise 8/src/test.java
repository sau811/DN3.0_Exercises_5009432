public class test {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCard);
        paymentContext.executePayment(100.0);

        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");
        paymentContext.setPaymentStrategy(payPal);
        paymentContext.executePayment(200.0);
    }
}
