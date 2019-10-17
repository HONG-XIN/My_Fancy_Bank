/**
 * stand for a checking bank account
 */
public class BankAccountChecking extends BankAccount implements BankAccountTypes {
    // constructor
    public BankAccountChecking() {
        super();
        setType(CHECKING);
    }
}
