import java.util.ArrayList;
import java.util.Random;

/**
 * stand for a bank
 */
public class Bank implements BankAccountTypes {
    // instance variables with private access
    private BankManager manager;
    private ArrayList<BankCustomer> customers;
    private BankChargeStandard chargeStandard;
    private MoneyExchangeRate exchangeRate;

    // constructor
    public Bank() {
        loadData();
    }

    // load data
    public void loadData() {
        manager = new BankManager();
        customers = new ArrayList<>();
        chargeStandard = new BankChargeStandard();
        exchangeRate = new MoneyExchangeRate();
    }

    // primary functions
    public void registerNewCustomer(String username, String password) {
        checkUsername(username);
        String customerNumber = generateRandomCustomerNumber();
        BankCustomer newCustomer = new BankCustomer(customerNumber);
        newCustomer.setUsername(username);
        newCustomer.setPassword(password);
        customers.add(newCustomer);
    }

    public BankCustomer getCustomerByUsername(String username) {
        for (BankCustomer b: customers) {
            if (username.equals(b.getUsername()))
                return b;
        }
        String alert = String.format("Cannot find customer with username as \"%s\"", username);
        throw new IllegalArgumentException(alert);
    }

    public void openAccount(BankCustomer customer, String type, String currency,
                            double value, int day, int month, int year) {
        double fee = getOpenAccountFeeByCurrency(currency);
        String accountNumber = generateRandomAccountNumber();
        customer.openAccount(accountNumber, type, currency, value, day, month, year, fee);
    }

    public void depositToAccount(BankCustomer customer, String accountNumber,
                                 double value, int day, int month, int year) {
        String type = customer.getAccountTypeByAccountNumber(accountNumber);
        double fee = 0.00;
        if (type.equals(CHECKING)) {
            String toAbbr = customer.getAccountCurrencyAbbrByAccountNumber(accountNumber);
            fee = getCheckingDepositFeeByCurrencyAbbr(toAbbr);
        }
        customer.depositToAccount(accountNumber, value, day, month, year, fee);
    }

    public void withdrawFromAccount(BankCustomer customer, String accountNumber,
                                    double value, int day, int month, int year) {
        String type = customer.getAccountTypeByAccountNumber(accountNumber);
        double fee = 0.00;
        if (type.equals(CHECKING)) {
            String toAbbr = customer.getAccountCurrencyAbbrByAccountNumber(accountNumber);
            fee = getCheckingWithdrawFeeByCurrencyAbbr(toAbbr);
        }
        customer.withdrawFromAccount(accountNumber, value, day, month, year, fee);
    }

    public void closeAccount(BankCustomer customer, String accountNumber, int day, int month, int year) {
        String toAbbr = customer.getAccountCurrencyAbbrByAccountNumber(accountNumber);
        double fee = getCloseAccountFeeByCurrencyAbbr(toAbbr);
        customer.closeAccount(accountNumber, day, month, year, fee);
    }

    // helper functions
    public String generateRandomCustomerNumber() {
        Random rand = new Random();
        int numberInt = rand.nextInt(1000000000);
        String number = String.valueOf(numberInt);
        while (!checkCustomerNumber(number)) {
            numberInt = rand.nextInt(1000000000);
            number = String.valueOf(numberInt);
        }
        return number;
    }

    public String generateRandomAccountNumber() {
        String number = BankNumber.generateRandomNumber();
        while (!checkAccountNumber(number))
            number = BankNumber.generateRandomNumber();
        return number;
    }

    public double getOpenAccountFeeByCurrency(String currency) {
        double fee = chargeStandard.getOpenAccountFeeValue();
        String fromAbbr = chargeStandard.getOpenAccountFeeAbbr();
        String toAbbr = CurrencyAbbrs.getAbbr(currency);
        return exchangeRate.calculate(fee, fromAbbr, toAbbr);
    }

    public double getCheckingDepositFeeByCurrencyAbbr(String toAbbr) {
        double fee = chargeStandard.getCheckingDepositFeeValue();
        String fromAbbr = chargeStandard.getCheckingDepositFeeAbbr();
        return exchangeRate.calculate(fee, fromAbbr, toAbbr);
    }

    public double getCheckingWithdrawFeeByCurrencyAbbr(String toAbbr) {
        double fee = chargeStandard.getCheckingWithdrawFeeValue();
        String fromAbbr = chargeStandard.getCheckingWithdrawFeeAbbr();
        return exchangeRate.calculate(fee, fromAbbr, toAbbr);
    }

    public double getCloseAccountFeeByCurrencyAbbr(String toAbbr) {
        double fee = chargeStandard.getCloseAccountFeeValue();
        String fromAbbr = chargeStandard.getCloseAccountFeeAbbr();
        return exchangeRate.calculate(fee, fromAbbr, toAbbr);
    }

    // check functions
    public void checkUsername(String username) {
        for (BankCustomer b: customers) {
            if (username.equals(b.getUsername())) {
                String alert = String.format("\"%s\" has been used.", username);
                throw new IllegalArgumentException(alert);
            }
        }
    }

    public boolean checkCustomerNumber(String number) {
        for (BankCustomer b: customers) {
            if (number.equals(b.getCustomerNumber()))
                return false;
        }
        return true;
    }

    public boolean checkAccountNumber(String number) {
        for (BankCustomer b: customers) {
            if (!b.checkEligibleAccountNumber(number))
                return false;
        }
        return true;
    }
}
