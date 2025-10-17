import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryService service = new LibraryService();

        service.addItem(new Book("Potop", "Sienkiewicz", 456));
        service.addItem(new Book("Ogniem i mieczem", "Sienkiewicz", 486));
        service.addItem(new Book("Krzyżacy", "Sienkiewicz", 416));
        service.addItem(new Movie("Psy", "Pasikowski", 101));
        service.addItem(new Movie("Psy 2", "Pasikowski", 111));
        service.addItem(new Movie("Psy 3", "Pasikowski", 121));

        int opt = 2;

        while (!(opt == 0)) {
            System.out.println("Dostępne opcje:\n 1-Wyświetl listę elementów \n 2-Wypożycz tytuł \n 3-Zwróć tytuł \n 4-Wyświetl liczbę elementów \n 0-Wyjdź z aplikacji");
            opt = input.nextInt();
            switch (opt) {
                case 1:
                    service.showLibraryItems();
                    service.showAvailableItems();
                    break;
                case 2:
                    System.out.println("Podaj tytuł który chcesz wypożyczyć: ");
                    String title = input.nextLine();
                    service.borrowItem(title);
                    break;
                case 3:
                    System.out.println("Podaj tytuł który chcesz zwrócić: ");
                    service.returnItem(input.nextLine());
                    break;
                case 4:
                    System.out.println("Filmów jest: " + LibraryService.licznikFilmow);
                    System.out.println("Książek jest: " + LibraryService.licznikKsiazek);
                    break;
            }
        }


        //service.showLibraryItems();
//        service.showNumbersOfLibraryItems();
//        System.out.println("Filmów jest: " + LibraryService.licznikFilmow);
//        System.out.println("Książek jest: " + LibraryService.licznikKsiazek);
//
//
//
//        service.showLibraryItems();
//        service.showNumbersOfLibraryItems();
//        service.showNumbersOfAvailableLibraryItems();
//        System.out.println("Filmów jest: " + LibraryService.licznikFilmow);
//        System.out.println("Książek jest: " + LibraryService.licznikKsiazek);
//
//        System.out.println("___________");
//        service.returnItem("Potop");
//
//        System.out.println("Filmów jest: " + LibraryService.licznikFilmow);
//        System.out.println("Książek jest: " + LibraryService.licznikKsiazek);
//        service.showNumbersOfAvailableLibraryItems();


    }
}
