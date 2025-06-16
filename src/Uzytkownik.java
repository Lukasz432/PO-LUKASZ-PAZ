public class Uzytkownik {
    private String login,haslo;
    private double stankonta;
    private int id;

    public Uzytkownik(int id, String login, String haslo, double stankonta){
        this.id = id;
        this.login = login;
        this.haslo = haslo;
        this.stankonta = stankonta;
    }

    public String GetLogin(){
        return this.login;
    }

    public Double GetStanKonta(){
        return this.stankonta;
    }

    public int GetId(){
        return this.id;
    }

    public void SetStanKonta(double stankonta){
        this.stankonta = stankonta;
    }
}
