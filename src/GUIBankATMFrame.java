import javax.swing.*;
import java.awt.*;

/**
 * the main window for bank ATM
 */
public class GUIBankATMFrame extends JFrame {
    // constructor
    public GUIBankATMFrame() {
        setAttributes();
    }

    // other functions
    public void setAttributes() {
        setTitle("Bank ATM");
        setSize(500, 500);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setVisible(true);
    }

    public void clear() {
        getContentPane().removeAll();
        repaint();
    }

    // show contents
    public void showLogin() {
        clear();
        add(new GUIBankLoginPanel(this));
        display("Login...", 300, 160);
    }

    public void showRegister() {
        clear();
        add(new GUIBankRegisterPanel(this));
        display("Register...", 300, 220);
    }
}
