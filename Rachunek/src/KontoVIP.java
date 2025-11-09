public class KontoVIP extends Konto {
    private double indywidualneOprocentowanie;
    private double limitDebetu;

    public KontoVIP(Osoba owner, double accountBalance, double indywidualneOprocentowanie, double limitDebetu) {
        super(owner, accountBalance);
        this.indywidualneOprocentowanie = indywidualneOprocentowanie;
        this.limitDebetu = limitDebetu;
    }

    @Override
    boolean wyplata(double value) {
        if (value <= accountBalance + limitDebetu) {
            accountBalance -= value;
            return true;
        } else return false;
    }

    @Override
    boolean przelew(Rachunek rachunek, double value) {
        if (rachunek != null && value <= accountBalance + limitDebetu) {
            rachunek.accountBalance += value;
            accountBalance -= value;
            return true;
        } else return false;
    }

    @Override
    void aktualizacja() {
        System.out.println("Konto VIP oprocentowane " + indywidualneOprocentowanie + "%");
        accountBalance += indywidualneOprocentowanie / 100 * accountBalance;
    }

    @Override
    public String toString() {
        return "Konto VIP " +
                "indywidualnie oprocentowane " + indywidualneOprocentowanie + " %" +
                ", limit debetu: " + limitDebetu +
                ", owner: " + owner +
                ", accountBalance:" + accountBalance;
    }
}