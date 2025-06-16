import javax.swing.*;

public class SklepGUI extends Frame{
    private JList list1;
    private JButton kupButton;
    private JButton sprzedajButton;
    private JButton wrocButton;
    private JPanel sklepPanel;
    private SklepController controller;
    private DefaultListModel<Gra> listModel;

    public SklepGUI(Uzytkownik uzytkownik){
        super("Sklep", 400,400);
        this.controller = new SklepController(this, uzytkownik);
        listModel = new DefaultListModel<>();
        list1.setModel(listModel);
        controller.OdswiezListeGier();

        this.setContentPane(sklepPanel);
        this.setVisible(true);

        kupButton.addActionListener(e -> controller.KupGre());
        sprzedajButton.addActionListener(e -> controller.SprzedajGre());
        wrocButton.addActionListener(e -> controller.Wroc());
    }

    public Gra GetSelectedGra(){
        return (Gra) this.list1.getSelectedValue();
    }

    public DefaultListModel GetListModel(){
        return this.listModel;
    }

    public JList GetList(){
        return this.list1;
    }
}
