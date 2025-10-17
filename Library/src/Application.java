import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryService service = new LibraryService();

        //System.out.println("Dostępne opcje:\n 1-Wyświetl listę elementów \n 2-Wypożycz tytuł \n 3-Zwróć tytuł \n 4-Wyświetl liczbę elementów \n 0-Wyjdź z aplikacji");

        //int opt = input.nextInt();

        service.addItem(new Book("Potop", "Sienkiewicz", 456));
        service.addItem(new Book("Ogniem i mieczem", "Sienkiewicz", 486));
        service.addItem(new Book("Krzyżacy", "Sienkiewicz", 416));
        service.addItem(new Movie("Psy", "Pasikowski", 101));
        service.addItem(new Movie("Psy 2", "Pasikowski", 111));
        service.addItem(new Movie("Psy 3", "Pasikowski", 121));
        //service.showLibraryItems();
        service.showNumbersOfLibraryItems();
        System.out.println("Filmów jest: " + LibraryService.licznikFilmow);
        System.out.println("Książek jest: " + LibraryService.licznikKsiazek);

        service.borrowItem(input.nextLine());

        service.showLibraryItems();
        service.showNumbersOfLibraryItems();
        service.showNumbersOfAvailableLibraryItems();
        System.out.println("Filmów jest: " + LibraryService.licznikFilmow);
        System.out.println("Książek jest: " + LibraryService.licznikKsiazek);

        System.out.println("___________");
        service.returnItem("Potop");

        System.out.println("Filmów jest: " + LibraryService.licznikFilmow);
        System.out.println("Książek jest: " + LibraryService.licznikKsiazek);
        service.showNumbersOfAvailableLibraryItems();
    }
}
