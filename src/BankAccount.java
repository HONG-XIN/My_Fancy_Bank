/**
 * stand for a bank account
 */
public class BankAccount {
    // instance variables with private access
    private BankNumberRouting routingNumber;
    private BankNumberAccount accountNumber;
    private Money balance;
    private BankTransactionsHistory transactions;
    private Date openDate;
    private Date lastUpdateDate;
    private String type;

    // constructor
    public BankAccount() {
        routingNumber = new BankNumberRouting();
        accountNumber = new BankNumberAccount();
        balance = new Money();
        transactions = new BankTransactionsHistory();
        openDate = new Date();
        lastUpdateDate = new Date();
        type = "";
    }

    public BankAccount(int day, int month, int year, String currency) {
        this();
        setCurrency(currency);
        setOpenDate(day, month, year);
    }

    // accessor functions
    public String getRoutingNumber() {
        return routingNumber.getCode();
    }

    public String getAccountNumber() {
        return accountNumber.getCode();
    }

    public float getBalance() {
        return balance.getAmount();
    }

    public String getCurrency() {
        return balance.getCurrency();
    }

    public String getOpenDate() {
        return openDate.toString();
    }

    public String getLastUpdateDate() {
        return lastUpdateDate.toString();
    }

    public String getType() {
        return type;
    }

    // mutator functions
    public void setRoutingNumber(String code) {
        routingNumber.setCode(code);
    }

    public void setAccountNumber(String code) {
        accountNumber.setCode(code);
    }

    public void setBalance(float amount) {
        balance.setAmount(amount);
    }

    public void setCurrency(String currency) {
        balance.setCurrency(currency);
    }

    public void addOneTransaction(int day, int month, int year, float amount, String from, String to) {
        checkFromTo(from, to);
        if (!from.equals("")) {
            float available = getBalance() + amount;
            transactions.addNewTransaction(day, month, year, getCurrency(), amount, available, from , to);
            addBalance(amount);
        } else {
            float available = getBalance() - amount;
            transactions.addNewTransaction(day, month, year, getCurrency(), amount, available, from , to);
            deductBalance(amount);
        }
        setLastUpdateDate(day, month, year);
    };

    public void setOpenDate(int day, int month, int year) {
        openDate.setDate(day, month, year);
    }

    public void setLastUpdateDate(int day, int month, int year) {
        openDate.setDate(day, month, year);
    }

    public void setType(String type) {
        this.type = type;
    }

    // change functions
    public void addBalance(float value) {
        balance.addAmount(value);
    }

    public void deductBalance(float value) {
        balance.deductAmount(value);
    }

    // check functions
    private void checkFromTo(String from, String to) {
        if (from.equals("") && to.equals(""))
            throw new IllegalArgumentException("\"From\" and \"To\" must not be both empty.");
        else if (!from.equals("") && !to.equals(""))
            throw new IllegalArgumentException("\"From\" and \"To\" must not be both not empty.");
    }
}
