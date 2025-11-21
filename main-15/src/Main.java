//1. Napisz program, który symuluje pobieranie trzech plików (każdy trwa 2 sekundy) i wykonaj to:
//        *    a) Synchronicznie
//         *    b) Asynchronicznie
//         *    Porównaj czasy wykonania.


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Wykonanie synchroniczne:");
        long startTimeSync = System.currentTimeMillis();

        pobierzPlik();
        pobierzPlik();
        pobierzPlik();

        long endTimeSync = System.currentTimeMillis();
        long durationSync = endTimeSync - startTimeSync;

        System.out.println("Czas wykonania (synchronicznie): " + durationSync + " ms");

        System.out.println("\nWykonanie synchroniczne:");
        long startTimeAsync = System.currentTimeMillis();

        Thread watek1 = new Thread(() -> pobierzPlik());
        Thread watek2 = new Thread(() -> pobierzPlik());
        Thread watek3 = new Thread(() -> pobierzPlik());

        watek1.start();
        watek2.start();
        watek3.start();

        try {
            watek1.join();
            watek2.join();
            watek3.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }

        long endTimeAsync = System.currentTimeMillis();
        long durationAsync = endTimeAsync - startTimeAsync;

        System.out.println("Czas wykonania (asynchronicznie): " + durationAsync + " ms");

//1. Napisz program, który tworzy pulę wątków o rozmiarze 2 i zgłasza 10 zadań polegających na wyświetleniu liczby od 1 do 10.

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 10; i++) {
            int liczba = i;
            executorService.submit(() -> {
                String nazwaWatku = Thread.currentThread().getName();
                System.out.println("Liczba: " + liczba + " ( wątek: " + nazwaWatku + " )");
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static void pobierzPlik() {
        try {
            System.out.println("Pobieranie pliku...");
            Thread.sleep(2000);
            System.out.println("Pobrano.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}