import java.awt.event.ActionEvent;

/**
 * event when user clicks REGISTER button in register panel
 */
public class GUIBankRegisterPanelLoginEvent extends GUIBankEvent {
    // constructor
    public GUIBankRegisterPanelLoginEvent(GUIBankATMFrame frame, Bank bank) {
        super(frame, bank);
    }

    // primary function
    public void actionPerformed(ActionEvent e) {
        GUIBankATMFrame frame = getFrame();
        frame.showLogin();
    }
}