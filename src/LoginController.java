import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    LoginGUI gui;

    public LoginController(LoginGUI gui){
        this.gui = gui;
    }

    public void Zaloguj(){
        String login = gui.GetLogin();
        String haslo = gui.GetPassword();

        if(!login.equals("") && !haslo.equals("")){
            // Tworzy zapytanie SQL na podstawie danych z formularza
            String sql = "SELECT * FROM klienci WHERE login='" + login + "' AND haslo='" + haslo +"'";
            ResultSet rs = BazaDanych.Zapytanie(sql); // Wykonuje zapytanie do bazy danych

            try {
                if(rs.isBeforeFirst()){ // Sprawdza, czy istnieje jakikolwiek wynik (czy użytkownik istnieje)
                    rs.next();

                    // Tworzy obiekt użytkownika z danych pobranych z bazy
                    Uzytkownik uzytkownik = new Uzytkownik(rs.getInt("id"),login,haslo,rs.getDouble("stan_konta"));

                    new AplikacjaGUI(uzytkownik); // Otwiera główne GUI aplikacji
                    gui.dispose(); // Zamyka okno logowania
                }
                else{
                    new Komunikat("Podane dane są nieprawidłowe!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            new Komunikat("Żadne pole nie może być puste!");
        }
    }
}
