public class DoladujController {
    private DoladujGUI gui;
    private Uzytkownik uzytkownik;

    public DoladujController(DoladujGUI gui, Uzytkownik uzytkownik){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
    }

    public void Doladuj() {
        if (!gui.GetIlosc().equals("")) {
            double ilosc = Double.parseDouble(gui.GetIlosc()); // Konwersja wprowadzonej kwoty do typu double

            if (ilosc > 0) {
                // Aktualizuje stan konta użytkownika w bazie danych
                String sql = "UPDATE klienci SET stan_konta=stan_konta + " + ilosc + " WHERE id=" + uzytkownik.GetId();
                BazaDanych.Polecenie(sql);

                // Aktualizuje stan konta również w obiekcie użytkownika w aplikacji
                uzytkownik.SetStanKonta(uzytkownik.GetStanKonta() + ilosc);

                new AplikacjaGUI(uzytkownik); // Powrót do głównego GUI aplikacji
                gui.dispose(); // Zamknięcie okna doładowania
            } else {
                new Komunikat("Musisz podać kwotę większą od 0!"); // Sprawdzenie, czy kwota jest dodatnia
            }
        } else {
            new Komunikat("Pole nie może być puste!"); // Walidacja pustego pola
        }
    }

    public void Wroc(){
        new AplikacjaGUI(uzytkownik); // Powrót bez doładowania
        gui.dispose();
    }
}
