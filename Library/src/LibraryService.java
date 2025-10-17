import java.util.ArrayList;

public class LibraryService {
    public ArrayList<LibraryItem> libraryItems = new ArrayList<>();

    public static int licznikKsiazek = 0;
    public static int licznikFilmow = 0;

    public void showLibraryItems() {
        System.out.println(libraryItems);
    }

    public void showAvailableItems(){
        System.out.println(availableLibraryItems);
    }

    public void showNumbersOfLibraryItems() {
        System.out.println(libraryItems.size());
    }

    public void showNumbersOfAvailableLibraryItems() {
        System.out.println(availableLibraryItems.size());
    }

    public void addItem(LibraryItem item) {
        libraryItems.add(item);
        availableLibraryItems.add(item);
        if (item instanceof Book) {
            licznikKsiazek++;
        } else {
            licznikFilmow++;
        }
    }

    public ArrayList<LibraryItem> availableLibraryItems = new ArrayList<>();


    public void borrowItem(String title) {
        int i = 0;
        int counter = 0;

        for (i = 0; i < availableLibraryItems.size(); i++) {
            if (availableLibraryItems.get(i).equals(new Book(title)) || availableLibraryItems.get(i).equals(new Movie(title))) {
                if (availableLibraryItems.get(i) instanceof Book) {
                    System.out.println("Wypożyczyłeś książkę pt. " + availableLibraryItems.get(i).toString());
                    licznikKsiazek--;
                } else {
                    System.out.println("Wypożyczyłeś film pt. " + availableLibraryItems.get(i).toString());
                    licznikFilmow--;
                }
                availableLibraryItems.remove(i);
                counter = 1;
                break;
            }
        }
        if (counter == 0) {
            System.err.println("Niestety nie mamy takiej pozycji w naszej bibliotece lub została już wypożyczona.");
        }
    }

    public void returnItem(String title) {
        int i = 0;
        int counter = 0;

        for (i = 0; i < libraryItems.size(); i++) {
            if (libraryItems.get(i).equals(new Book(title)) || libraryItems.get(i).equals(new Movie(title))) {
                for (int j = 0; j < availableLibraryItems.size(); j++) {
                    if (availableLibraryItems.get(j).equals(new Book(title)) || availableLibraryItems.get(j).equals(new Movie(title))) {
                        System.err.println("Nie możesz zwrócić książki, która nie została wypożyczona!");
                        counter = 2;
                        break;
                    }
                }
                while (!(counter == 2)) {
                    if (libraryItems.get(i) instanceof Book) {
                        System.out.println("Zwróciłeś książkę pt. " + libraryItems.get(i).toString());
                        licznikKsiazek++;
                    } else {
                        System.out.println("Zwróciłeś film pt. " + libraryItems.get(i).toString());
                        licznikFilmow++;
                    }
                    availableLibraryItems.add(libraryItems.get(i));
                    counter = 1;
                    break;
                }
            }
        }
        if (counter == 0) {
            System.err.println("Niestety nie mamy takiej pozycji w naszej bibliotece więc nie możesz jej zwrócić");
        }
    }
}