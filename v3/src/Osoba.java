public class Osoba {
    protected String imie, nazwisko;
    public Osoba(String ii, String nn){imie=ii;nazwisko=nn;}
    public Osoba(Osoba o){imie=o.imie;nazwisko=o.nazwisko;}
    public void modyfikuj(String i, String n){
        imie = i;
        nazwisko = n;
    }
    public String getDane(){
        return imie+" "+nazwisko;
    }
}
