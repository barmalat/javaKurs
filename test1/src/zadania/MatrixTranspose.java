package zadania;

import java.util.Scanner;

public class MatrixTranspose {
    public static void main(String[] args) {
        double[][] matrixA = new double[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj wierszami współczynniki dla macierzy A:");
        //wypełnianie:
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }
        //wyświetlanie:
        for (int i = 0; i < matrixA.length; i++) {
            System.out.println();
            for (int j = 0; j < matrixA[0].length; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
        }
        System.out.println();

        System.out.println("Wyświetlam macierz transponowaną z macierzy A:");
        for (int i = 0; i < matrixA.length; i++) {
            System.out.println();
            for (int j = 0; j < matrixA[0].length; j++) {
                System.out.print(matrixA[j][i] + " ");
            }
        }
    }
}
