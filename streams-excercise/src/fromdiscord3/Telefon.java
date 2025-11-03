package fromdiscord3;

import java.awt.*;

public class Telefon implements WyswietlHistoriePolaczen {
    private String interfejsKomunikacyjny;
    private Color color;

    public void zadzwon(String number){
        System.out.println("Dzwonię pod numer: " + number);
    }

    public Telefon(String interfejsKomunikacyjny, Color color) {
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
        this.color = color;
    }

    public String getInterfejsKomunikacyjny() {
        return interfejsKomunikacyjny;
    }

    public void setInterfejsKomunikacyjny(String interfejsKomunikacyjny) {
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        System.out.println("brak historii");
    }
}