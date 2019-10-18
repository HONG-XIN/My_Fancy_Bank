/**
 * store some fees and rates
 */
public class BankChargeStandard implements CurrencyAbbrs {
    // instance variables with private access
    private Money openAccountFee;
    private Money closeAccountFee;
    private Money checkingDepositFee;
    private Money checkingWithdrawFee;
    private double savingInterestRate;
    private Money savingInterestLine;
    private double loanInterestRate;
    private Money loanInterestLine;
    private double loanInterestRateDefault;

    // constructor
    public BankChargeStandard() {
        loadData();
    }

    // load data
    public void loadData() {
        openAccountFee = new Money(USD, 10);
        closeAccountFee = new Money(USD, 10);
        checkingDepositFee = new Money(USD, 10);
        checkingWithdrawFee = new Money(USD, 10);
        savingInterestRate = 0.01;
        savingInterestLine = new Money(USD, 2000);
        loanInterestRate = 0.08;
        loanInterestLine = new Money(USD, 2000);
        loanInterestRateDefault = 0.04;
    }

    // primary function
    public double getOpenAccountFeeValue() {
        return openAccountFee.getAmount();
    }

    public String getOpenAccountFeeAbbr() {
        return openAccountFee.getCurrencyAbbr();
    }

    public double getCheckingDepositFeeValue() {
        return checkingDepositFee.getAmount();
    }

    public String getCheckingDepositFeeAbbr() {
        return checkingDepositFee.getCurrencyAbbr();
    }

    public double getCheckingWithdrawFeeValue() {
        return checkingWithdrawFee.getAmount();
    }

    public String getCheckingWithdrawFeeAbbr() {
        return checkingWithdrawFee.getCurrencyAbbr();
    }

    public double getCloseAccountFeeValue() {
        return closeAccountFee.getAmount();
    }

    public String getCloseAccountFeeAbbr() {
        return closeAccountFee.getCurrencyAbbr();
    }

}
