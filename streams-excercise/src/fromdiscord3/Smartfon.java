package fromdiscord3;

import java.awt.Color;
import java.util.Arrays;

public class Smartfon extends Komorka implements WyswietlHistoriePolaczen {

    private Osoba[] znajomi;

    public Smartfon(String interfejsKomunikacyjny, Color color, Osoba[] znajomi) {
        super(interfejsKomunikacyjny, color);
        this.znajomi = znajomi;
    }

    @Override
    public void zadzwon(String number) {
        super.zadzwon(number);
    }

    public String numberInBookFormated(String number) {
        return Arrays.stream(znajomi)
                .filter(osoba -> osoba.getNumer().equals(number))
                .findFirst()
                .map(Object::toString)
                .orElse(number);
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        for (String lastTenCall : lastTenCalls) {
            System.out.println(numberInBookFormated(lastTenCall));
        }
    }
}