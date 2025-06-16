public class Gra {
    String nazwa, gatunek;
    int sprzedawcaId, id;
    double cena;

    public Gra(String nazwa, String gatunek){
        this.nazwa = nazwa;
        this.gatunek = gatunek;
    }

    public Gra(String nazwa, String gatunek, double cena, int sprzedawcaId, int id){
        this.nazwa = nazwa;
        this.gatunek = gatunek;
        this.cena = cena;
        this.sprzedawcaId = sprzedawcaId;
        this.id = id;
    }

    @Override
    public String toString(){
        return this.nazwa + " | Gatunek: " + this.gatunek + " | Cena: " + this.cena + "zł";
    }

    public String GetNazwa(){
        return this.nazwa;
    }

    public String GetGatunek(){
        return this.gatunek;
    }

    public double GetCena(){
        return this.cena;
    }

    public int GetId(){
        return this.id;
    }
}
