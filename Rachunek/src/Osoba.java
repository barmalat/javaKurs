public class Osoba {
    private String firstName;
    private String lastName;

    public Osoba(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}