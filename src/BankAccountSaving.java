/**
 * extend for a saving bank account
 */
public class BankAccountSaving extends BankAccount implements BankAccountTypes {
    // constructor
    public BankAccountSaving(int day, int month, int year, String currency) {
        super(day, month, year, currency);
        setType(SAVING);
    }
}
