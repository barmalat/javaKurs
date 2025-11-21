//1. Napisz program, który planuje połączenie konferencyjne między osobami w Sydney, Berlinie i San Francisco. Wyświetl lokalne godziny dla każdego uczestnika.

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        // Ustalamy godzinę spotkania w UTC
        LocalDateTime dataSpotkaniaUTC = LocalDateTime.of(2023, Month.OCTOBER, 15, 14, 0);
        ZonedDateTime spotkanieUTC = dataSpotkaniaUTC.atZone(ZoneId.of("UTC"));
        System.out.println("\nGodzina spotkania w UTC: " + spotkanieUTC);

        // Strefy czasowe dla miast
        ZoneId strefaSydney = ZoneId.of("Australia/Sydney");
        ZoneId strefaBerlin = ZoneId.of("Europe/Berlin");
        ZoneId strefaTokio = ZoneId.of("America/Los_Angeles");

        // Konwersja czasu na lokalne strefy czasowe
        ZonedDateTime spotkanieLondyn = spotkanieUTC.withZoneSameInstant(strefaSydney);
        ZonedDateTime spotkanieNowyJork = spotkanieUTC.withZoneSameInstant(strefaBerlin);
        ZonedDateTime spotkanieTokio = spotkanieUTC.withZoneSameInstant(strefaTokio);

        // Wyświetlenie godzin spotkania w różnych strefach
        System.out.println("Godzina spotkania w Londynie: " + spotkanieLondyn);
        System.out.println("Godzina spotkania w Nowym Jorku: " + spotkanieNowyJork);
        System.out.println("Godzina spotkania w Tokio: " + spotkanieTokio);

    }
}