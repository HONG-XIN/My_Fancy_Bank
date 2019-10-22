/**
 * stand for a money in one certain currency
 */
public class Money {
    // instance variables with private access
    private Currency currency;
    private double amount;

    // constructor
    public Money(String currency, double amount) {
        setCurrency(currency);
        setAmount(amount);
    }

    /**
     * by default, set currency to be USD and amount to be 0
     */
    public Money() {
        this("CurrencyUSD", 0);
    }

    // accessor functions
    public String getCurrencyType() {
        return currency.getType();
    }

    public String getCurrencyAbbr() {
        return currency.getAbbr();
    }

    public String getCurrency() {
        return currency.toString();
    }

    public double getAmount() {
        return amount;
    }

    // mutator functions
    public void setCurrency(String currency) {
        CurrencyFactory currencyFactory = new CurrencyFactory();
        this.currency = currencyFactory.getCurrency(currency);
        if (this.currency == null) {
            String alert = String.format("\"%s\" currency is not valid right now.", currency);
            throw new IllegalArgumentException(alert);
        }
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // change functions
    public void addAmount(double value) {
        amount += value;
    }

    public void deductAmount(double value) {
        amount -= value;
    }
}
