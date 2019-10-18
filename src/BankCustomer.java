import java.util.ArrayList;

/**
 * stands for a bank customer
 */
public class BankCustomer extends Member implements BankAccountTypes {
    // instance variable with private access
    private String customerNumber;
    private ArrayList<BankAccount> accounts;

    // constructor
    public BankCustomer(String number) {
        super();
        accounts = new ArrayList<>();
        setCustomerNumber(number);
    }

    // accessor function
    public String getCustomerNumber() {
        return customerNumber;
    }

    public BankAccount getAccountByAccountNumber(String accountNumber) {
        for (BankAccount b: accounts)
            if (accountNumber.equals(b.getAccountNumber()))
                return b;
        String alert = String.format("\"%s\" is not found in this customer.", accountNumber);
        throw new IllegalArgumentException(alert);
    }

    public String getAccountCurrencyAbbrByAccountNumber(String accountNumber) {
        BankAccount b = getAccountByAccountNumber(accountNumber);
        return b.getCurrencyAbbr();
    }

    public String getAccountTypeByAccountNumber(String accountNumber) {
        BankAccount b = getAccountByAccountNumber(accountNumber);
        return b.getType();
    }

    public double getAccountBalanceByAccountNumber(String accountNumber) {
        BankAccount b = getAccountByAccountNumber(accountNumber);
        return b.getBalance();
    }

    // mutator function
    public void setCustomerNumber(String number) {
        checkCustomerNumber(number);
        this.customerNumber = customerNumber;
    }

    // check function
    /**
     * must be a 9 digit number
     */
    public void checkCustomerNumber(String number) {
        try {
            if (number.length() != 9)
                throw new NumberFormatException();
            int numberInt = Integer.parseInt(number);
            if (numberInt < 0)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            String alert = String.format("\"%s\" is not a valid customer number.", number);
            throw new IllegalArgumentException(alert);
        }
    }

    // primary function
    public void openAccount(String accountNumber, String type, String currency,
                            double value, int day, int month, int year, double fee) {
        if (!checkEligibleAccountNumber(accountNumber))
            throw new IllegalArgumentException("account number is duplicate.");
        if (value < fee)
            throw new IllegalArgumentException("Deposit is not enough to open an account.");
        BankAccount b;
        if (type.equals(CHECKING)) {
            b = new BankAccountChecking(currency);
            b.open(day, month, year);
        } else if (type.equals(SAVING)) {
            b= new BankAccountSaving(currency);
            b.open(day, month, year);
        } else if (type.equals(LOAN)) {
            b = new BankAccountLoan(currency);
            b.open(day, month, year);
        } else {
            String alert = String.format("\"%s\" type is not configured.", type);
            throw new IllegalArgumentException(alert);
        }
        b.setAccountNumber(accountNumber);
        b.addOneTransaction(day, month, year, value, "Customer", "");
        b.addOneTransaction(day, month, year, fee, "", "Bank");
        accounts.add(b);
    }

    public void depositToAccount(String accountNumber, double value, int day, int month, int year, double fee) {
        BankAccount b = getAccountByAccountNumber(accountNumber);
        double balance = b.getBalance();
        if (balance + value < fee)
            throw new IllegalArgumentException("Don't have enough money to make this deposit.");
        b.addOneTransaction(day, month, year, value, "Customer", "");
        if (fee > 0)
            b.addOneTransaction(day, month, year, fee, "", "Bank");
    }

    public void withdrawFromAccount(String accountNumber, double value, int day, int month, int year, double fee) {
        BankAccount b = getAccountByAccountNumber(accountNumber);
        double balance = b.getBalance();
        if (balance < value + fee)
            throw new IllegalArgumentException("Don't have enough money to make this withdraw.");
        b.addOneTransaction(day, month, year, value, "", "Customer");
        if (fee > 0)
            b.addOneTransaction(day, month, year, fee, "", "Bank");
    }

    public void closeAccount(String accountNumber, int day, int month, int year, double fee) {
        BankAccount b = getAccountByAccountNumber(accountNumber);
        double balance = b.getBalance();
        if (balance < fee)
            throw new IllegalArgumentException("Balance is not enough to close this account.");
        b.addOneTransaction(day, month, year, balance-fee, "", "Customer");
        b.addOneTransaction(day, month, year, fee, "", "Bank");
        accounts.remove(b);
    }

    // check function
    public boolean checkEligibleAccountNumber(String number) {
        for (BankAccount b: accounts) {
            if (number.equals(b.getAccountNumber()))
                return false;
        }
        return true;
    }
}
