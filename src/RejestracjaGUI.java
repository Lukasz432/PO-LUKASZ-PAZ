import javax.swing.*;

public class RejestracjaGUI extends Frame{
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton zarejestrujButton;
    private JPanel rejestracjaPanel;
    private JButton wrocButton;
    private RejestracjaController controller;

    public RejestracjaGUI(){
        super("Panel Rejestracji",200 ,300);
        this.controller = new RejestracjaController(this);

        this.setContentPane(rejestracjaPanel);
        this.setVisible(true);

        zarejestrujButton.addActionListener(e -> controller.Zarejestuj());
        wrocButton.addActionListener(e -> controller.Wroc());
    }

    public String GetLogin(){
        return loginField.getText();
    }

    public String GetPassword(){
        return passwordField.getText();
    }


}
