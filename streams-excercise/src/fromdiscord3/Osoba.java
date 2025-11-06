package fromdiscord3;

public class Osoba {
    private String imie;
    private String nazwisko;
    private String numer;

    public Osoba(String imie, String nazwisko, String numer) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numer = numer;
    }

    public String getNumer() {
        return numer;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " " + numer;
    }
}