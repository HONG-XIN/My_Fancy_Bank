/**
 * stand for a money in one certain currency
 */
public class Money {
    // instance variables with private access
    private Currency currency;
    private float amount;

    // constructor
    public Money(String currency, float amount) {
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
    public String getCurrency() {
        return currency.toString();
    }

    public float getAmount() {
        return amount;
    }

    // mutator functions
    public void setCurrency(String currency) {
        try {
            this.currency = (Currency) Class.forName(currency).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            String alert = String.format("\"%s\" currency is not valid right now.", currency);
            throw new IllegalArgumentException(alert);
        }
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    // change functions
    public void addAmount(float value) {
        amount += value;
    }

    public void deductAmount(float value) {
        amount -= value;
    }
}
