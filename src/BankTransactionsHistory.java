import java.util.ArrayList;

/**
 * record list of transactions happened in one account
 */
public class BankTransactionsHistory {
    // instance variable with private access
    private ArrayList<BankTransaction> history;

    // constructors
    public BankTransactionsHistory() {
        history = new ArrayList<>();
    }

    // mutator function
    public void addNewTransaction(int day, int month, int year, String currency, float amount,
                                  float available, String from, String to) {
        BankTransaction t = new BankTransaction();
        t.setTransactionDate(day, month, year);
        t.setCurrency(currency);
        t.setAmount(amount);
        t.setAvailable(available);
        t.setFrom(from);
        t.setTo(to);
        history.add(t);
    }
}
