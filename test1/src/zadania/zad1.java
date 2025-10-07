package zadania;

import java.util.Scanner;

public class zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wymiary prostokąta:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < b; i++) {
            System.out.println();
            for (int j = 0; j < a; j++) {
                if (i == 0) {
                    System.out.print("*");
                } else if (i == b - 1) {
                    System.out.print("*");
                }
                else {
                    if (j == 0) {
                        System.out.print("*");
                    } else if (j == a - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                }
            }
        }
    }
