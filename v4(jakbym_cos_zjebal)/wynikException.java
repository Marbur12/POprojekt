//kolejna prosta klasa do obslugi bledow
class wynikException extends RuntimeException{
    private int wynik;
    public wynikException(){}
    public wynikException(String wiadomosc, int w){super(wiadomosc);wynik=w;}
}
