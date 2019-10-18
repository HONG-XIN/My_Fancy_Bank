/**
 * This contains the main function to trigger the project.
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        GUIBankATMFrame tf = new GUIBankATMFrame(bank);
        tf.showLogin();
    }
}
