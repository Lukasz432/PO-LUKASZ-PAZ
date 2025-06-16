import javax.swing.*;

public class DoladujGUI extends Frame{
    private JTextField textField1;
    private JButton doladujButton;
    private JPanel panel;
    private JButton wrocButton;
    private DoladujController controller;

    public DoladujGUI(Uzytkownik uzytkownik){
        super("Doładuj konto!",300,300);
        controller = new DoladujController(this, uzytkownik);

        this.setContentPane(panel);
        this.setVisible(true);

        wrocButton.addActionListener(e -> controller.Wroc());
        doladujButton.addActionListener(e -> controller.Doladuj());
    }

    public String GetIlosc(){
        return textField1.getText();
    }
}
