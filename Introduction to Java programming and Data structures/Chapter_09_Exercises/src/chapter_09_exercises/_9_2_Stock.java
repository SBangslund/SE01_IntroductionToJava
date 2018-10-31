package chapter_09_exercises;

/**
 * @author Samuel Bangslund
 */
public class _9_2_Stock {

    private final String symbol;
    private final String name;
    
    private double previousClosingPrice;
    private double currentPrice;

    public _9_2_Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public double getChangePercent() {
        return previousClosingPrice / currentPrice * 100 - 100;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    public double getPreviousPrice() {
        return this.previousClosingPrice;
    }

    public double getCurrentPrice() {
        return this.currentPrice;
    }
    
    public void setPreviousClosingPrice(double price) {
        this.previousClosingPrice = (price >= 0) ? price : previousClosingPrice;
    }
    
    public void setCurrentPrice(double price) {
        this.currentPrice = (price >= 0) ? price : currentPrice;
    }
}
