/**
 * stands for a loan
 */
public class BankAccountLoan extends BankAccount implements BankAccountTypes {
    // constructor
    public BankAccountLoan(int day, int month, int year, String currency) {
        super(day, month, year, currency);
        setType(LOAN);
    }
}
