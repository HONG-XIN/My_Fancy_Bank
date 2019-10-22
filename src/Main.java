import java.text.DecimalFormat;

/**
 * This contains the main function to trigger the project.
 */
public class Main {
    public static void main(String[] args) {
//        String a = String.format("%-8s XXXXX%d %s%s", "Loan", 5555, "$", new DecimalFormat("#.##").format(3.2222));
//        System.out.println(a);


        Bank bank = Bank.getInstance();
        bank.registerNewCustomer("dezhouw", "Aa123456", "dezhouw@sina.com");


        GUIBankATMFrame tf = new GUIBankATMFrame();
        tf.showLogin();
    }
}
