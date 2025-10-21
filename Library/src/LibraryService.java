import java.util.ArrayList;

public class LibraryService {
    public ArrayList<LibraryItem> libraryItems = new ArrayList<>();

    public static int licznikKsiazek = 0;
    public static int licznikFilmow = 0;

    public void showLibraryItems() {
        System.out.println("Wszystkie pozycje: " + libraryItems);
    }

    public void addItem(LibraryItem item) {
        libraryItems.add(item);
        if (item instanceof Book) {
            licznikKsiazek++;
        } else {
            licznikFilmow++;
        }
    }

    public void increaseCounter(LibraryItem item) {
        if (item instanceof Book) {
            licznikKsiazek++;
        } else {
            licznikFilmow++;
        }
    }

    public void reduceCounter(LibraryItem item) {
        if (item instanceof Book) {
            licznikKsiazek--;
        } else {
            licznikFilmow--;
        }
    }

    public LibraryItem findByTitle(String title) {
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public void borrowItem(String title) {
        LibraryItem item = findByTitle(title);
        if (item == null) {
            System.err.println("Nie mamy takiej pozycji w bibliotece.");
        } else if (!item.isAvailability()) {
            System.err.println("Niestety ta pozycja została już wypożyczona.");
        } else {
            System.out.println("Wypożyczasz: " + item);
            item.setAvailability(false);
            reduceCounter(item);
        }
    }

    public void returnItem(String title) {
        LibraryItem item = findByTitle(title);
        if (item == null) {
            System.err.println("Nie mamy takiej pozycji w bibliotece.");
        } else if (item.isAvailability()) {
            System.err.println("Niestety ta pozycja nie została jeszcze wypożyczona.");
        } else {
            System.out.println("Oddajesz: " + item);
            item.setAvailability(true);
            increaseCounter(item);
        }
    }
}