package fromdiscord3;

import java.awt.*;
import java.util.Arrays;

public class Smartfon extends Komorka implements WyswietlHistoriePolaczen {
    public Osoba[] getZnajomi() {
        return znajomi;
    }

    public void setZnajomi(Osoba[] znajomi) {
        this.znajomi = znajomi;
    }

    private Osoba[] znajomi;

    public Smartfon(String interfejsKomunikacyjny, Color color, String[] lastTenCalls, Osoba[] znajomi) {
        super(interfejsKomunikacyjny, color, lastTenCalls);
        this.znajomi = znajomi;
    }

    public Smartfon(String interfejsKomunikacyjny, Color color, Osoba[] znajomi) {
        super(interfejsKomunikacyjny, color);
        this.znajomi = znajomi;
    }

    @Override
    public void zadzwon(String number) {
        super.zadzwon(number);
    }

    public boolean numberInBook(String number) {
        return Arrays.stream(getZnajomi())
                .anyMatch(znajomi -> znajomi.getNumer().equals(number));
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        for (int i = 0; i < getLastTenCalls().length; i++) {
            if (numberInBook(getLastTenCalls()[i])) {
                for (int j = 0; j < getZnajomi().length; j++) {
                    if (getLastTenCalls()[i].equals(getZnajomi()[j].getNumer())) {
                        System.out.println(getZnajomi()[j].getImie() + " " + getZnajomi()[j].getNazwisko() + " " + getZnajomi()[j].getNumer());
                    }
                }
            }else System.out.println(getLastTenCalls()[i]);
        }
    }
}