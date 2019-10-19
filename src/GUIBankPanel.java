import javax.swing.*;

public class GUIBankPanel extends JPanel {
    // instance variable with private access
    private GUIBankATMFrame frame;

    // constructor
    public GUIBankPanel(GUIBankATMFrame frame) {
        this.frame = frame;
    }

    // accessor functions
    public GUIBankATMFrame getFrame() {
        return frame;
    }
}
