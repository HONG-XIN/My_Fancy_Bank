import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * abstract event class for bank
 */
public abstract class GUIBankEvent implements ActionListener {
    // instance variables with private access
    private GUIBankATMFrame frame;
    private Bank bank;

    // constructor
    public GUIBankEvent(GUIBankATMFrame frame, Bank bank) {
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

    // abstract function
    public abstract void actionPerformed(ActionEvent e);
}
