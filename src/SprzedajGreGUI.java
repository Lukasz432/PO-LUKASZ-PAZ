import javax.swing.*;

public class SprzedajGreGUI extends Frame{
    private JTextField nazwaField;
    private JTextField gatunekField;
    private JTextField cenaField;
    private JButton sprzedajButton;
    private JPanel sprzedajGrePanel;
    private JButton wrocButton;
    private SprzedajGreController controller;

    public SprzedajGreGUI(Uzytkownik uzytkownik){
        super("Sprzedaj Grę", 400,400);
        this.controller = new SprzedajGreController(this, uzytkownik);

        this.setContentPane(sprzedajGrePanel);
        this.setVisible(true);

        sprzedajButton.addActionListener(e -> controller.SprzedajGre());
        wrocButton.addActionListener(e -> controller.Wroc());
    }

    public String GetNazwa(){
        return nazwaField.getText();
    }

    public String GetGatunek(){
        return gatunekField.getText();
    }

    public String GetCena(){
        return cenaField.getText();
    }
}
