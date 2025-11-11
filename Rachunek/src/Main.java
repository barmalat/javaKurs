public class Main {
    public static void main(String[] args) {
        Rachunek[] rachunki = new Rachunek[3];
        rachunki[0] = new Rachunek(new Osoba("Jan", "Kowal"), 1000);
        rachunki[1] = new Konto(new Osoba("Janusz", "Kowalski"), 2000);
        rachunki[2] = new KontoVIP(new Osoba("Jan Paweł", "Kowalewski"), 3000, 50, 1000);

        System.out.println(rachunki[0]);
        System.out.println(rachunki[1]);
        System.out.println(rachunki[2]);
        System.out.println();

        Konto.zmienOprocentowanie(10);
        System.out.println(rachunki[0].wplata(100));
        System.out.println(rachunki[1].wplata(100));
        System.out.println(rachunki[2].wplata(100));
        System.out.println();

        System.out.println(rachunki[0]);
        System.out.println(rachunki[1]);
        System.out.println(rachunki[2]);
        System.out.println();

        System.out.println(rachunki[0].wyplata(100));
        System.out.println(rachunki[0].wyplata(10000));
        System.out.println(rachunki[1].wyplata(100));
        System.out.println(rachunki[1].wyplata(10000));
        System.out.println(rachunki[2].wyplata(100));
        System.out.println(rachunki[2].wyplata(10000));
        System.out.println(rachunki[2].wyplata(3500));
        System.out.println();

        System.out.println(rachunki[0]);
        System.out.println(rachunki[1]);
        System.out.println(rachunki[2]);
        System.out.println();

        System.out.println(rachunki[0].przelew(rachunki[2], 1000));
        System.out.println(rachunki[0]);
        System.out.println(rachunki[2]);
        System.out.println();

        rachunki[0].aktualizacja();
        rachunki[1].aktualizacja();
        rachunki[2].aktualizacja();
        System.out.println();

        System.out.println(rachunki[0]);
        System.out.println(rachunki[1]);
        System.out.println(rachunki[2]);
    }
}