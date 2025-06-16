import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AplikacjaController {
    private AplikacjaGUI gui;
    private Uzytkownik uzytkownik;

    public AplikacjaController(AplikacjaGUI gui, Uzytkownik uzytkownik){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
    }

    public void PrzejdzDoSklepu(){
        new SklepGUI(uzytkownik); // Przekazuje użytkownika do interfejsu sklepu
        gui.dispose(); // Zamyka obecne okno GUI
    }

    public void OdswiezListeGier(){
        DefaultListModel listModel = gui.GetListModel(); // Pobiera model listy z GUI, który reprezentuje widoczne gry

        // Zapytanie pobierające wszystkie gry przypisane do zalogowanego użytkownika
        String sql = "SELECT * FROM grywbibliotece WHERE wlasciciel_id=" + uzytkownik.GetId();
        ResultSet rs = BazaDanych.Zapytanie(sql); // Wykonanie zapytania do bazy

        try {
            while (rs.next()) {
                String nazwa = rs.getString("nazwa"); // Pobranie nazwy gry z bieżącego wiersza wyniku
                listModel.addElement(nazwa); // Dodanie gry do listy w GUI
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void PanelDoladowania(){
        new DoladujGUI(uzytkownik); // Tworzy panel doładowania, przekazując dane użytkownika
        gui.dispose(); // Zamyka aktualne okno GUI
    }
}
