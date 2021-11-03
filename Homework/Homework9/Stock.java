/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    31 October 2021

    A program that allows a main method to create a stock option and
    also allows the main method to call upon various getters and setters.

*/

public class Stock {

    private String symbol, name;                // Variables
    private double prevClosPrice, currentPrice;


    public Stock(String symbol, String name, double prevClosPrice, double currentPrice) { // Constructor
        this.symbol = symbol;
        this.name = name;
        this.prevClosPrice = prevClosPrice;
        this.currentPrice = currentPrice;
    }

    // Setters - Name and Symbol not needed since those should be the same for the existence of the company
    public void setCurrentPrice(double n) { setPrevClosPrice(this.currentPrice); this.currentPrice = n;  } // Sets new price and calls setPrevClosPrice giving the old value
    public void setPrevClosPrice(double n) { this.prevClosPrice = n; }

    // Getters
    public String getSymbol() { return this.symbol; }
    public String getName() { return this.name; }
    public double getPrevClosPrice() { return this.prevClosPrice; }
    public double getcurrentPrice() { return this.currentPrice; }
    public double getChangePercent() { return ((prevClosPrice / currentPrice) * 100) - 100.0; } // Returns the percentage of change, positive is increase, negative is decrease

}
