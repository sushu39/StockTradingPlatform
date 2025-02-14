public class Mn{
    public static void main(String[] args) {
            TradingAccount account = new TradingAccount(10000.0);
            Stock stock1 = new Stock("AAPL", 150.0);
            Stock stock2 = new Stock("GOOG", 2500.0);
            account.buyStock(stock1, 10);
            account.buyStock(stock2, 5);
            account.printPortfolio();
            account.sellStock(stock1, 5);
            account.printPortfolio();
    }
}