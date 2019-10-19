import java.awt.event.ActionEvent;

/**
 * event when user clicks REGISTER button in register panel
 */
public class GUIBankRegisterPanelLoginEvent extends GUIBankEvent {
    // constructor
    public GUIBankRegisterPanelLoginEvent(GUIBankATMFrame frame) {
        super(frame);
    }

    // primary function
    public void actionPerformed(ActionEvent e) {
        GUIBankATMFrame frame = getFrame();
        frame.showLogin();
    }
}