import java.util.ArrayList;
import java.util.List;

public class TradingAccount {
    private List<Stock> portfolio;
    private double balance;

    public TradingAccount(double balance) {
        this.portfolio = new ArrayList<>();
        this.balance = balance;
    }

    public void buyStock(Stock stock, int quantity) {
        double totalCost = stock.getPrice() * quantity;
        if (balance >= totalCost) {
            balance -= totalCost;
            for (int i = 0; i < quantity; i++) {
                portfolio.add(stock);
            }
            System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int sharesOwned = 0;
        for (Stock s : portfolio) {
            if (s.getSymbol().equals(stock.getSymbol())) {
                sharesOwned++;
            }
        }
        if (sharesOwned >= quantity) {
            double totalRevenue = stock.getPrice() * quantity;
            balance += totalRevenue;
            for (int i = 0; i < quantity; i++) {
                portfolio.remove(stock);
            }
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("You do not own enough shares to sell");
        }
    }

    public void printPortfolio() {
        System.out.println("Portfolio:");
        for (Stock stock : portfolio) {
            System.out.println(stock.getSymbol() + ": " + stock.getPrice());
        }
        System.out.println("Balance: " + balance);
    }
}