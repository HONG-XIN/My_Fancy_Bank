/**
 * A bunch of money with value and currency type.
 */
public class Money implements CurrencyTypes {
    // instance variables with private access
    private Currency currency;
    private double amount;

    // constructor
    public Money(String currencyType, double amount) {
        setCurrency(currencyType);
        setAmount(amount);
    }

    /**
     * by default, set currency to be USD and amount to be 0
     */
    public Money() {
        this(USD, 0);
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
        assert CurrencyTypes.isCurrencyTypeValid(currency): "Currency type not valid.";
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

    public void changeCurrencyType(String newCurrencyType) {
        String oldCurrencyType = getCurrencyType();
        CurrencyExchangeRate exchangeRate = CurrencyExchangeRate.getInstance();
        double rate = exchangeRate.getRate(oldCurrencyType, newCurrencyType);
        setCurrency(newCurrencyType);
        amount *= rate;
    }

    public void addMoney(Money newMoney) {
        String toCurrencyType = getCurrencyType();
        amount += newMoney.getAmountByCurrencyType(toCurrencyType);
    }

    public void deductMoney(Money newMoney) {
        String toCurrencyType = getCurrencyType();
        amount -= newMoney.getAmountByCurrencyType(toCurrencyType);
    }

    public double getAmountByCurrencyType(String newCurrencyType) {
        String oldCurrencyType = getCurrencyType();
        CurrencyExchangeRate exchangeRate = CurrencyExchangeRate.getInstance();
        double rate = exchangeRate.getRate(oldCurrencyType, newCurrencyType);
        return getAmount() * rate;
    }
}
