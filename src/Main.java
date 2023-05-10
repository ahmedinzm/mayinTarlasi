import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int row, column, mines, r, c;
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        System.out.print("Satır Giriniz : ");
        row = scanner.nextInt();
        System.out.print("Sütun Giriniz : ");
        column = scanner.nextInt();
        mines = (int) ((row * column) / 4.0);
        int[][] mineField = new int[row][column];
        boolean[][] revealed = new boolean[row][column];
        int[][] mineLocations = new int[mines][2];

        // Mayınları yerleştirme aşaması
        for (int i = 0; i < mines; i++) {
            do {
                r = random.nextInt(row);
                c = random.nextInt(column);
            } while (mineField[r][c] == -1);
            mineField[r][c] = -1;
            mineLocations[i][0] = r;
            mineLocations[i][1] = c;
        }

        // Mayınlar olmayan hücrelerin değerlerinin hesaplanması aşaması
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mineField[i][j] != -1) {
                    int count = 0;
                    if (i > 0 && j > 0 && mineField[i - 1][j - 1] == -1) count++;
                    if (i > 0 && mineField[i - 1][j] == -1) count++;
                    if (i > 0 && j < column - 1 && mineField[i - 1][j + 1] == -1) count++;
                    if (j > 0 && mineField[i][j - 1] == -1) count++;
                    if (j < column - 1 && mineField[i][j + 1] == -1) count++;
                    if (i < row - 1 && j > 0 && mineField[i + 1][j - 1] == -1) count++;
                    if (i < row - 1 && mineField[i + 1][j] == -1) count++;
                    if (i < row - 1 && j < column - 1 && mineField[i + 1][j + 1] == -1) count++;
                    mineField[i][j] = count;
                }
            }
        }

        // Oyunun oynanması aşaması
        while (true) {
            System.out.println("===========================");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (!revealed[i][j]) {
                        System.out.print("- ");
                    } else if (mineField[i][j] == -1) {
                        System.out.print("* ");
                    } else {
                        System.out.print(mineField[i][j] + " ");
                    }
                }
                System.out.println();
            }
            System.out.print("Satır Giriniz : ");
            int x = scanner.nextInt();
            System.out.print("Sütun Giriniz : ");
            int y = scanner.nextInt();
            if (x >= 0 && x < row && y >= 0 && y < column) {
                if (mineField[x][y] == -1) {
                    System.out.println("Game Over!!");
                    break;
                } else {
                    reveal(mineField, revealed, x, y);
                    boolean win = true;
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                            if (!revealed[i][j] && mineField[i][j] != -1) {
                                win = false;
                                break;
                            }
                        }
                    }
                    if (win) {
                        System.out.println("Oyunu Kazandınız !");
                        break;
                    }
                }
            }
        }
    }

    private static void reveal(int[][] mineField, boolean[][] revealed, int x, int y) {
        if (revealed[x][y]) {
            return;
        }
        revealed[x][y] = true;
        if (mineField[x][y] != 0) {
            return;
        }
        if (x > 0 && y > 0) {
            reveal(mineField, revealed, x - 1, y - 1);
        }
        if (x > 0) {
            reveal(mineField, revealed, x - 1, y);
        }
        if (x > 0 && y < mineField[0].length - 1) {
            reveal(mineField, revealed, x - 1, y + 1);
        }
        if (y > 0) {
            reveal(mineField, revealed, x, y - 1);
        }
        if (y < mineField[0].length - 1) {
            reveal(mineField, revealed, x, y + 1);
        }
        if (x < mineField.length - 1 && y > 0) {
            reveal(mineField, revealed, x + 1, y - 1);
        }
        if (x < mineField.length - 1) {
            reveal(mineField, revealed, x + 1, y);
        }
        if (x < mineField.length - 1 && y < mineField[0].length - 1) {
            reveal(mineField, revealed, x + 1, y + 1);
        }
    }
}