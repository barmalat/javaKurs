import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryService service = new LibraryService();
        boolean isRunning = true;

        service.addItem(new Book("Potop", "Sienkiewicz", 456));
        service.addItem(new Book("Ogniem i mieczem", "Sienkiewicz", 486));
        service.addItem(new Book("Krzyżacy", "Sienkiewicz", 416));
        service.addItem(new Movie("Psy", "Pasikowski", 101));
        service.addItem(new Movie("Psy 2", "Pasikowski", 111));
        service.addItem(new Movie("Psy 3", "Pasikowski", 121));

        String opt;

        while (isRunning) {
            System.out.println("\nDostępne opcje:\n 1-Wyświetl listę elementów \n 2-Wypożycz tytuł \n 3-Zwróć tytuł \n 4-Wyświetl liczbę elementów \n 0-Wyjdź z aplikacji");
            opt = input.nextLine();
            switch (opt) {
                case "1" -> service.showLibraryItems();
                case "2" -> {
                    System.out.println("Podaj tytuł który chcesz wypożyczyć: ");
                    try {
                        service.borrowItem(input.nextLine());
                    } catch (ItemIsNotAvailableException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case "3" -> {
                    System.out.println("Podaj tytuł który chcesz zwrócić: ");
                    try{
                        service.returnItem(input.nextLine());
                    } catch (ItemAlreadyAvailableException e){
                        System.err.println(e.getMessage());
                    }
                }
                case "4" -> {
                    System.out.println("Filmów jest: " + LibraryService.licznikFilmow);
                    System.out.println("Książek jest: " + LibraryService.licznikKsiazek);
                }
                case "0" -> isRunning = false;
                default -> System.err.println("Nie ma takiej opcji w programie.");
            }
        }
    }
}