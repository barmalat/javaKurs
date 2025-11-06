package fromdiscord3;


import java.awt.Color;

public class Telefon implements WyswietlHistoriePolaczen {
    private String interfejsKomunikacyjny;
    private Color color;

    public void zadzwon(String number) {
        System.out.println("Dzwonię pod numer: " + number);
    }

    public Telefon(String interfejsKomunikacyjny, Color color) {
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
        this.color = color;
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        System.out.println("brak historii");
    }
}