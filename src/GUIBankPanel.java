import javax.swing.*;

public class GUIBankPanel extends JPanel {
    // instance variable with private access
    private GUIBankATMFrame frame;
    private Bank bank;

    // constructor
    public GUIBankPanel(GUIBankATMFrame frame, Bank bank) {
        this.frame = frame;
        this.bank = bank;
    }

    // accessor functions
    public GUIBankATMFrame getFrame() {
        return frame;
    }

    public Bank getBank() {
        return bank;
    }
}
