/**
 * stands for a loan
 */
public class BankAccountLoan extends BankAccount implements BankAccountTypes {
    // constructor
    public BankAccountLoan() {
        super();
        setType(LOAN);
    }
}
