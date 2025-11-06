package homework;

import homework.generator.HoldingGenerator;
import homework.generator.UserGenerator;
import homework.model.*;
import homework.model.Currency;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exercises {

    private static final List<Holding> holdings = new HoldingGenerator().generate();
    private static final List<User> users = new UserGenerator().generate();

    public static void main(String[] args) {
        System.out.println("1: " + getHoldingsWhereAreCompanies());
        System.out.println("2: " + getHoldingNames());
        System.out.println("3: " + getHoldingNamesAsString());
        System.out.println("4: " + getCompaniesAmount());
        System.out.println("5: " + getAllUserAmount());
        System.out.println("6: " + getAllCompaniesNamesAsLinkedList());
        System.out.println("7: " + getAccountAmountInPLN(users.getFirst().getAccounts().getFirst()));
        System.out.println("8: " + getUsersForPredicate(user -> user.getSex() == Sex.OTHER));
        System.out.println("9: ");
        executeForEachCompany(company -> System.out.println(company.getName()));
        System.out.println("10: " + getRichestWoman()
                .map(user -> user.getFirstName() + " " + user.getLastName()));
        System.out.println("11: " + getFirstNCompany(4));
        System.out.println("12: " + getUserPerCompany());
        String getUserToString = getUser(user -> user.getAge() > 10).getFirstName();
        System.out.println("13: " + getUserToString);
        System.out.println("14: " + createAccountsMap());
        System.out.println("15: " + getUserNames());
        System.out.print("16: ");
        showAllUser();
        System.out.println("17: " + getCurenciesSet());
    }

    /**
     * 1
     * Napisz metodę, która zwróci liczbę holdingów, w których jest przynajmniej jedna firma.
     */
    public static long getHoldingsWhereAreCompanies() {
        return holdings.stream()
                .filter(holding -> holding.getCompanies() != null && !holding.getCompanies().isEmpty())
                .count();
    }

    /**
     * 2
     * Napisz metodę, która zwróci nazwy wszystkich holdingów pisane z wielkiej litery w formie listy.
     */
    public static List<String> getHoldingNames() {
        return holdings.stream()
                .map(Holding::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * 3
     * Zwraca nazwy wszystkich holdingów sklejone w jeden string i posortowane.
     * String ma postać: (Coca-Cola, Nestle, Pepsico)
     */
    public static String getHoldingNamesAsString() {
        return holdings.stream()
                .map(Holding::getName)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    /**
     * 4
     * Zwraca liczbę firm we wszystkich holdingach.
     */
    public static long getCompaniesAmount() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream())
                .count();
    }

    /**
     * 5
     * Zwraca liczbę wszystkich pracowników we wszystkich firmach.
     */
    public static long getAllUserAmount() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream())
                .mapToLong(company -> company.getUsers().size())
                .sum();
    }

    /**
     * 6
     * Zwraca listę wszystkich firm jako listę, której implementacja to LinkedList. Obiektów nie przepisujemy
     * po zakończeniu działania strumienia.
     */
    public static LinkedList<String> getAllCompaniesNamesAsLinkedList() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream())
                .map(Company::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * 7
     * Przelicza kwotę na rachunku na złotówki za pomocą kursu określonego w enum Currency.
     */
    public static BigDecimal getAccountAmountInPLN(Account account) {
        return account
                .getAmount()
                .multiply(BigDecimal.valueOf(account.getCurrency().rate))
                .round(new MathContext(4, RoundingMode.HALF_UP));
    }

    /**
     * 8
     * Zwraca imiona użytkowników w formie zbioru, którzy spełniają podany warunek.
     */
    public static Set<String> getUsersForPredicate(final Predicate<User> userPredicate) {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream())
                .flatMap(company -> company.getUsers().stream())
                .filter(userPredicate)
                .map(User::getFirstName)
                .collect(Collectors.toSet());
    }

    /**
     * 9
     * Dla każdej firmy uruchamia przekazaną metodę.
     */
    public static void executeForEachCompany(Consumer<Company> consumer) {
        getCompanyStream()
                .forEach(consumer);
    }

    /**
     * 10
     * Wyszukuje najbogatsza kobietę i zwraca ją. Metoda musi uzwględniać to że rachunki są w różnych walutach.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/55052733/9360524
    public static Optional<User> getRichestWoman() {
        return users.stream()
                .filter(user -> user.getSex() == Sex.WOMAN)
                .max(Comparator.comparing(user -> getUserAmountInPLN(user)));

    }

    private static BigDecimal getUserAmountInPLN(final User user) {
        return user.getAccounts().stream()
                .map(account -> getAccountAmountInPLN(account))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * 11
     * Zwraca nazwy pierwszych N firm. Kolejność nie ma znaczenia.
     */
    private static Set<String> getFirstNCompany(final int n) {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream())
                .map(Company::getName)
                .limit(n)
                .collect(Collectors.toSet());
    }

    /**
     * 12
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników.
     */
    public static Map<String, List<User>> getUserPerCompany() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream())
                .collect(Collectors.toMap(Company::getName, Company::getUsers));
//                .collect(Collectors.toMap(Company::getName, company -> company.getUsers()
//                        .stream()
//                        .map(user -> (user.getFirstName() + " " + user.getLastName()))
//                        .toList()
//                ));
    }

    /**
     * 13
     * Zwraca pierwszego z brzegu użytkownika dla podanego warunku. W przypadku kiedy nie znajdzie użytkownika, wyrzuca
     * wyjątek IllegalArgumentException.
     */
    public static User getUser(final Predicate<User> predicate) {
        return users
                .stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nie ma użytkownika spełniającego zadany filtr"));
    }

    /**
     * 14
     * Zwraca mapę rachunków, gdzie kluczem jest numer rachunku, a wartością ten rachunek.
     */
    public static Map<String, Account> createAccountsMap() {
        return getAccoutStream()
                .collect(Collectors.toMap(Account::getNumber, Function.identity()));
    }

    /**
     * 15
     * Zwraca listę wszystkich imion w postaci Stringa, gdzie imiona oddzielone są spacją i nie zawierają powtórzeń.
     */
    public static String getUserNames() {
        return users.stream()
                .map(User::getFirstName)
                .sorted()
                .distinct()
                .collect(Collectors.joining(" "));
    }

    /**
     * 16
     * Metoda wypisuje na ekranie wszystkich użytkowników (imię, nazwisko) posortowanych od z do a.
     * Zosia Psikuta, Zenon Kucowski, Zenek Jawowy ... Alfred Pasibrzuch, Adam Wojcik
     */
    public static void showAllUser() {
        users.stream()
                .map(user -> user.getFirstName() + " " + user.getLastName())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    /**
     * 17
     * Zwraca zbiór walut w jakich są rachunki.
     */
    public static Set<Currency> getCurenciesSet() {
        return users.stream()
                .flatMap(user -> user.getAccounts().stream())
                .map(Account::getCurrency)
                .collect(Collectors.toSet());
    }

    /**
     * Zwraca strumień wszystkich firm.
     */
    private static Stream<Company> getCompanyStream() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream());
    }

    /**
     * Tworzy strumień użytkowników.
     */
    private static Stream<User> getUserStream() {
        return getCompanyStream()
                .flatMap(company -> company.getUsers().stream());
    }

    /**
     * Tworzy strumień rachunków.
     */
    private static Stream<Account> getAccoutStream() {
        return getUserStream()
                .flatMap(user -> user.getAccounts().stream());
    }
}