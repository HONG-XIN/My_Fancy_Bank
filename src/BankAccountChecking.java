/**
 * stand for a checking bank account
 */
public class BankAccountChecking extends BankAccount implements BankAccountTypes {
    // constructor
    public BankAccountChecking(int day, int month, int year, String currency) {
        super(day, month, year, currency);
        setType(CHECKING);
    }

    // change functions
    public void deposit(int day, int month, int year, float value) {
        addOneTransaction(day, month, year, value, "Customer", "");
    }

    public void withdraw(int day, int month, int year, float value) {
        addOneTransaction(day, month, year, value, "", "Customer");
    }
}
