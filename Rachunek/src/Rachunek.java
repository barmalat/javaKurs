public class Rachunek {
    protected Osoba owner;
    protected double accountBalance;

    public Rachunek(Osoba owner, double accountBalance) {
        this.owner = owner;
        this.accountBalance = accountBalance;
    }

    boolean wplata(double value) {
        accountBalance += value;
        return true;
    }

    boolean wyplata(double value) {
        if (value <= accountBalance) {
            accountBalance -= value;
            return true;
        } else return false;
    }

    boolean przelew(Rachunek rachunek, double value) {
        if (rachunek != null && value <= accountBalance) {
            rachunek.accountBalance += value;
            accountBalance -= value;
            return true;
        } else return false;
    }

    void aktualizacja() {
        System.out.println("Rachunek podstawowy");
    }

    @Override
    public String toString() {
        return "Rachunek: " +
                "owner: " + owner +
                ", accountBalance: " + accountBalance;
    }
}