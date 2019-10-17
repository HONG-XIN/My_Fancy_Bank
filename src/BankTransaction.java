/**
 * stand for one single bank transaction
 */
public class BankTransaction {
    // instance variables with private access
    private Date transactionDate;
    private Currency currency;
    private float amount;
    private float available;
    private String from;
    private String to;

    // constructors
    public BankTransaction() {
        transactionDate = new Date();
        setCurrency("CurrencyUSD");
        amount = 0;
        available = 0;
        from = "";
        to = "";
    }

    // accessor functions
    public float getAmount() {
        return amount;
    }

    public float getAvailable() {
        return available;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    // mutator functions
    public void setTransactionDate(int day, int month, int year) {
        transactionDate.setDate(day, month, year);
    }

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

    public void setAvailable(float available) {
        this.available = available;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
