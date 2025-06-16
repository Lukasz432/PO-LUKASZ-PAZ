public class SprzedajGreController {
    private SprzedajGreGUI gui;
    private Uzytkownik uzytkownik;

    public SprzedajGreController(SprzedajGreGUI gui, Uzytkownik uzytkownik){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
    }

    public void SprzedajGre() {
        String nazwa = gui.GetNazwa();
        String gatunek = gui.GetGatunek();
        String cena = gui.GetCena();

        if (!nazwa.equals("") && !gatunek.equals("") && !cena.equals("")) {
            double cenaDouble = Double.parseDouble(cena); // Konwersja ceny z tekstu na liczbę zmiennoprzecinkową

            if (cenaDouble >= 0) {
                // Wstawia nową grę do sklepu jako ofertę sprzedaży
                String sql = "INSERT INTO grywsklepie(nazwa,gatunek,cena,sprzedawca_id) VALUES('" + nazwa + "','" + gatunek + "'," + cenaDouble + "," + uzytkownik.GetId() + ")";
                BazaDanych.Polecenie(sql);

                new SklepGUI(uzytkownik); // Powrót do widoku sklepu po dodaniu gry
                gui.dispose();
            } else {
                new Komunikat("Cena nie może być ujemna!"); // Walidacja wartości ceny
            }

        } else {
            new Komunikat("Żadne pole nie może być puste!"); // Sprawdzenie pustych pól
        }
    }

    public void Wroc(){
        new SklepGUI(uzytkownik); // Powrót do sklepu bez sprzedaży
        gui.dispose();
    }
}
