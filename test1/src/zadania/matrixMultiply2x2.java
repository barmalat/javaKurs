package zadania;

import java.util.Scanner;

public class matrixMultiply2x2 {
    public static void main(String[] args) {
        double[][] matrixA = new double[2][2];
        double[][] matrixB = new double[2][2];
        double[][] multiplyMatrix = new double[2][2];

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

        //wypełnianie:
        System.out.println("podaj wierszami współczynniki dla macierzy B:");
        for (int i = 0; i < matrixB.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }
        //wyświetlanie:
        for (int i = 0; i < matrixB.length; i++) {
            System.out.println();
            for (int j = 0; j < matrixB[0].length; j++) {
                System.out.print(matrixB[i][j] + " ");
            }
        }
        System.out.println();

        //obliczanie:
        for (int i = 0; i < multiplyMatrix.length; i++) {
            for (int j = 0; j < multiplyMatrix[0].length; j++) {
                multiplyMatrix[i][j] = 0;
                for (int k = 0; k < multiplyMatrix[0].length; k++) {
                    multiplyMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        System.out.println("W wyniku mnożenia zadanych macierzy, otrzymujemy macierz:");
        //wyświetlanie:
        for (int i = 0; i < multiplyMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < multiplyMatrix[0].length; j++) {
                System.out.print(multiplyMatrix[i][j] + " ");
            }
        }
    }
}