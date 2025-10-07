package zadania;

import java.util.Scanner;

//public class zad2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj wysokość piramidy:");
//        int h = scanner.nextInt();
//
//        for (int i = 0; i < h + 1; i++) {
//            System.out.println();
//            for (int n = 0; n < h - i; n++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j < 2 * i ; j++) {
//                System.out.print("*");
//            }
//        }
//    }
//}
////todo: spróbować rozszerzyć piramidę 1-5-9

public class zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wysokość piramidy:");
        int h = scanner.nextInt();

        for (int i = 0; i < h + 1; i++) {
            System.out.println();
            for (int n = 0; n < 2*h - 2*i; n++) {
                System.out.print(" ");
            }
            for (int j = 1; j < 4 * i - 2 ; j++) {
                System.out.print("*");
            }
        }
    }
}