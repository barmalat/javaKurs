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

    public void increaseCounter(LibraryItem item){
        if (item instanceof Book) {
            licznikKsiazek++;
        } else {
            licznikFilmow++;
        }
    }

    public void reduceCounter(LibraryItem item){
        if (item instanceof Book) {
            licznikKsiazek--;
        } else {
            licznikFilmow--;
        }
    }

    public boolean findByTitle(String title) {
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAvailability(String title){
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getTitle().equals(title)) {
                return libraryItem.isAvailability();
            }
        }
        return false;
    }

    public void borrowItem(String title) {
        if (findByTitle(title)){
            if (checkAvailability(title)){
                for (int i = 0; i < libraryItems.size(); i++) {
                    if (libraryItems.get(i).getTitle().equals(title)) {
                        System.out.println("Wypożyczasz: " + libraryItems.get(i).toString());
                        libraryItems.get(i).setAvailability(false);
                        reduceCounter(libraryItems.get(i));
                    }
                }
            }
            else {
                System.err.println("Niestety ta pozycja została już wypożyczona.");
            }
        }
        else {
            System.err.println("Nie mamy takiej pozycji w bibliotece.");
        }
    }

    public void returnItem(String title) {
        if (findByTitle(title)){
            if (!checkAvailability(title)){
                for (int i = 0; i < libraryItems.size(); i++) {
                    if (libraryItems.get(i).getTitle().equals(title)) {
                        System.out.println("Oddajesz: " + libraryItems.get(i).toString());
                        libraryItems.get(i).setAvailability(true);
                        increaseCounter(libraryItems.get(i));
                    }
                }
            }
            else {
                System.err.println("Nie możesz zwrócić czegoś, co nie zostało wypożyczone.");
            }
        }
        else {
            System.err.println("Nie mamy takiej pozycji w bibliotece.");
        }
    }

//    public void borrowItem(String title) {
//        int i;
//        int counter = 0;
//
//        for (i = 0; i < availableLibraryItems.size(); i++) {
//            if (availableLibraryItems.get(i).equals(new Book(title)) || availableLibraryItems.get(i).equals(new Movie(title))) {
//                if (availableLibraryItems.get(i) instanceof Book) {
//                    System.out.println("Wypożyczyłeś książkę pt. " + availableLibraryItems.get(i).toString());
//                    licznikKsiazek--;
//                } else {
//                    System.out.println("Wypożyczyłeś film pt. " + availableLibraryItems.get(i).toString());
//                    licznikFilmow--;
//                }
//                availableLibraryItems.remove(i);
//                counter = 1;
//                break;
//            }
//        }
//        if (counter == 0) {
//            System.err.println("Niestety nie mamy takiej pozycji w naszej bibliotece lub została już wypożyczona.");
//        }
//    }
//
//    public void returnItem(String title) {
//        int i;
//        int counter = 0;
//
//        for (i = 0; i < libraryItems.size(); i++) {
//            if (libraryItems.get(i).equals(new Book(title)) || libraryItems.get(i).equals(new Movie(title))) {
//                for (LibraryItem availableLibraryItem : availableLibraryItems) {
//                    if (availableLibraryItem.equals(new Book(title)) || availableLibraryItem.equals(new Movie(title))) {
//                        System.err.println("Nie możesz zwrócić książki, która nie została wypożyczona!");
//                        counter = 2;
//                        break;
//                    }
//                }
//                if (!(counter == 2)) {
//                    if (libraryItems.get(i) instanceof Book) {
//                        System.out.println("Zwróciłeś książkę pt. " + libraryItems.get(i).toString());
//                        licznikKsiazek++;
//                    } else {
//                        System.out.println("Zwróciłeś film pt. " + libraryItems.get(i).toString());
//                        licznikFilmow++;
//                    }
//                    availableLibraryItems.add(libraryItems.get(i));
//                    counter = 1;
//                }
//            }
//        }
//        if (counter == 0) {
//            System.err.println("Niestety nie mamy takiej pozycji w naszej bibliotece więc nie możesz jej zwrócić");
//        }
//    }
}