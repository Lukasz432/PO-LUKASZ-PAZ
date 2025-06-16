import java.sql.*;

public class BazaDanych {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SteamAplikacja2";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private static Connection connection;
    private static Statement statement;

    public static Connection ConnectToDataBase(){
        try{
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Metoda do wykonywania zapytań SELECT – zwraca ResultSet z danymi
    public static ResultSet Zapytanie(String sql){
        try{
            if(connection == null){
                // Jeśli brak połączenia – nawiązywane jest nowe i tworzony jest Statement
                connection = ConnectToDataBase();
                statement = connection.createStatement();
            }

            return statement.executeQuery(sql); // Wykonanie zapytania SELECT i zwrócenie wyników

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Metoda do wykonywania zapytań typu INSERT, UPDATE, DELETE – nie zwraca wyniku
    public static void Polecenie(String sql){
        try{
            if(connection == null){
                // Tworzenie połączenia, jeśli jeszcze nie istnieje
                connection = ConnectToDataBase();
                statement = connection.createStatement();
            }

            statement.execute(sql); // Wykonanie polecenia modyfikującego dane

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
