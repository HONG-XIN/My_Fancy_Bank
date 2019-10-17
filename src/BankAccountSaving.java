/**
 * extend for a saving bank account
 */
public class BankAccountSaving extends BankAccount implements BankAccountTypes {
    // constructor
    public BankAccountSaving() {
        super();
        setType(SAVING);
    }
}
