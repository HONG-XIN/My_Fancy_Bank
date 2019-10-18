import java.awt.event.ActionEvent;

/**
 * event when user clicks REGISTER button in login panel
 */
public class GUIBankLoginPanelRegisterEvent extends GUIBankEvent {
    // constructor
    public GUIBankLoginPanelRegisterEvent(GUIBankATMFrame frame, Bank bank) {
        super(frame, bank);
    }

    // primary function
    public void actionPerformed(ActionEvent e) {
        GUIBankATMFrame frame = getFrame();
        frame.showRegister();
    }
}
