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
}
