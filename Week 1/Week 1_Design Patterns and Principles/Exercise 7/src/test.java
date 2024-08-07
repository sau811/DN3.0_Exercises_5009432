public class test {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(150.75);
        stockMarket.setStockPrice(155.30);

        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStockPrice(160.00);
    }
}
