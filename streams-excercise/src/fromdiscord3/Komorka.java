package fromdiscord3;

import java.awt.*;
import java.util.Arrays;

public class Komorka extends Telefon implements WyswietlHistoriePolaczen{
    protected String[] lastTenCalls = new String[10];

    @Override
    public void zadzwon(String number) {
        super.zadzwon(number);
        for (int i = 9; i >0 ; i--) {
            lastTenCalls[i] = lastTenCalls[i-1];
        }
        lastTenCalls[0] = number;
    }

    public Komorka(String interfejsKomunikacyjny, Color color) {
        super(interfejsKomunikacyjny, color);
    }

    @Override
    public void wyswietlHistoriePolaczen() {
        System.out.println(Arrays.toString(lastTenCalls));
    }
}