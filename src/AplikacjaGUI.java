import javax.swing.*;

public class AplikacjaGUI extends Frame{
    private JList list1;
    private DefaultListModel<String> listModel;
    private JButton sklepButton;
    private JButton doladujKontoButton;
    private JPanel aplikacjaPanel;
    private JLabel loginText;
    private JLabel stanKontaText;
    private AplikacjaController controller;

    public AplikacjaGUI(Uzytkownik uzytkownik){
        super("Steam",550,300);
        this.controller = new AplikacjaController(this, uzytkownik);
        loginText.setText(uzytkownik.GetLogin());
        stanKontaText.setText(uzytkownik.GetStanKonta() + " zł");
        listModel = new DefaultListModel<>();
        list1.setModel(listModel);
        controller.OdswiezListeGier();

        this.setContentPane(aplikacjaPanel);
        this.setVisible(true);

        sklepButton.addActionListener(e -> controller.PrzejdzDoSklepu());
        doladujKontoButton.addActionListener(e -> controller.PanelDoladowania());
    }

    public DefaultListModel GetListModel(){
        return this.listModel;
    }
}
