import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SklepController {
    private SklepGUI gui;
    private Uzytkownik uzytkownik;

    public SklepController(SklepGUI gui, Uzytkownik uzytkownik){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
    }

    public void OdswiezListeGier(){
        String sql = "SELECT * FROM grywsklepie";
        ResultSet rs = BazaDanych.Zapytanie(sql);
        DefaultListModel lista = gui.GetListModel();

        try {
            while (rs.next()) {
                String nazwa = rs.getString("nazwa");
                String gatunek = rs.getString("gatunek");
                double cena = rs.getDouble("cena");
                int sprzedawca_id = rs.getInt("sprzedawca_id");
                int id = rs.getInt("id");

                // Tworzy obiekt gry i dodaje go do listy GUI
                Gra gra = new Gra(nazwa, gatunek, cena, sprzedawca_id, id);
                lista.addElement(gra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Odświeża komponent listy w GUI
        gui.GetList().revalidate();
        gui.GetList().repaint();
    }

    public void KupGre() {
        Gra gra = gui.GetSelectedGra(); // Pobiera zaznaczoną grę z listy
        double stanKonta = uzytkownik.GetStanKonta();

        if (gra.sprzedawcaId != uzytkownik.GetId()) { // Użytkownik nie może kupić własnej gry
            if (gra.GetCena() <= stanKonta) { // Sprawdza, czy użytkownik ma wystarczająco pieniędzy

                // Dodaje grę do biblioteki użytkownika
                String sql = "INSERT INTO grywbibliotece(nazwa,gatunek,wlasciciel_id) VALUES('" + gra.GetNazwa() + "','" + gra.GetGatunek() + "'," + uzytkownik.GetId() + ")";
                BazaDanych.Polecenie(sql);

                // Usuwa grę ze sklepu
                String sql2 = "DELETE FROM grywsklepie WHERE id=" + gra.GetId();
                BazaDanych.Polecenie(sql2);

                // Odejmuje kwotę z konta kupującego
                String sql3 = "UPDATE klienci SET stan_konta=stan_konta-" + gra.GetCena() + " WHERE id=" + uzytkownik.GetId();
                BazaDanych.Polecenie(sql3);

                // Dodaje kwotę do konta sprzedawcy
                String sql4 = "UPDATE klienci SET stan_konta=stan_konta+" + gra.GetCena() + " WHERE id=" + gra.sprzedawcaId;
                BazaDanych.Polecenie(sql4);

                // Usuwa grę z listy w GUI
                gui.GetListModel().removeElement(gra);

                // Aktualizuje stan konta użytkownika w aplikacji
                uzytkownik.SetStanKonta(stanKonta - gra.GetCena());

            } else {
                new Komunikat("Nie posiadasz tyle pieniędzy!");
            }
        } else {
            new Komunikat("Nie możesz kupić swojej gry!"); // Zabezpieczenie przed kupnem własnej gry
        }
    }

    public void SprzedajGre(){
        new SprzedajGreGUI(uzytkownik); // Przejście do okna sprzedaży gry
        gui.dispose(); // Zamknięcie aktualnego okna
    }

    public void Wroc(){
        new AplikacjaGUI(uzytkownik); // Powrót do głównego GUI aplikacji
        gui.dispose();
    }
}
