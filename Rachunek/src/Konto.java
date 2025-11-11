public class Konto extends Rachunek {
    private static double oprocentowanie = 0;

    public Konto(Osoba owner, double accountBalance) {
        super(owner, accountBalance);
    }

    public static void zmienOprocentowanie(double oprocentowanie) {
        Konto.oprocentowanie = oprocentowanie;
    }

    @Override
    void aktualizacja() {
        System.out.println("Konto oprocentowane " + oprocentowanie + "%");
        accountBalance += oprocentowanie / 100 * accountBalance;
    }

    @Override
    public String toString() {
        return "Konto oprocentowane: " + oprocentowanie +
                ", owner: " + owner +
                ", accountBalance: " + accountBalance;
    }
}