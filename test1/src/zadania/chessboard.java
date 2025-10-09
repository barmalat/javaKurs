package zadania;

import java.util.Scanner;

public class chessboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wymiar kwadratowej szachownicy do wyświetlenia:");
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println();
            if (i % 2 == 0) {
                for (int j = 0; j < a; j++) {
                    System.out.print(j % 2 == 0 ? "#" : " ");
                }
            } else {
                for (int j = 0; j < a; j++) {
                    System.out.print(j % 2 == 0 ? " " : "#");
                }
            }
        }
    }
}