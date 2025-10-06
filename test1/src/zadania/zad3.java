package zadania;

public class zad3 {
    public static void main(String[] args) {
int [][] tab = new int[3][3];
int x = 1;
        for (int i = 0; i < tab.length; i++) {
            System.out.println();
            for (int j = 0; j < tab[0].length; j++) {
                tab[i][j] = x++;
                System.out.print(tab[i][j]);
            }

        }
//        tab [0][0] = 1;
//        tab [0][1] = 2;
//        tab [0][2] = 3;
//        tab [1][0] = 4;
//        tab [1][1] = 5;
//        tab [1][2] = 6;
//        tab [2][0] = 7;
//        tab [2][1] = 8;
//        tab [2][2] = 9;
//        System.out.println(tab [0][0] + " " + tab[0][1] + " " + tab[0][2]);
//        System.out.println(tab [1][0] + " " + tab[1][1] + " " + tab[1][2]);
//        System.out.println(tab [2][0] + " " + tab[2][1] + " " + tab[2][2]);

    }
}
