import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginGUI extends Frame{
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton zalogujButton;
    private JPanel logowaniePanel;
    private JLabel rejestracjaLabel;
    private LoginController controller;

    public LoginGUI(){
        super("Panel Logowania", 400,300);
        controller = new LoginController(this);

        this.setContentPane(logowaniePanel);
        this.setVisible(true);

        zalogujButton.addActionListener(e -> controller.Zaloguj());

        rejestracjaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new RejestracjaGUI();
            }
        });
    }

    public String GetLogin(){
        return loginField.getText();
    }

    public String GetPassword(){
        return passwordField.getText();
    }
}
