package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static Scanner scanner = new Scanner(System.in);
    public static char[][] map;
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void initMAP() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            return false;
        if (map[x][y] == DOT_EMPTY)
            return true;
        return false;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты Х, У");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValid(x, y));
        map[x][y] = DOT_X;
    }

    public static void aiTurn() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isValid(x, y));
        map[x][y] = DOT_O;
    }

    public static boolean checkTheWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            if ((map[i][0] == symb && map[i][1] == symb && map[i][2] == symb && map[i][3] == symb) ||
                    (map[i][1] == symb && map[i][2] == symb && map[i][3] == symb && map[i][4] == symb) ||
                    (map[0][i] == symb && map[1][i] == symb && map[2][i] == symb && map[3][i] == symb) ||
                    (map[1][i] == symb && map[2][i] == symb && map[3][i] == symb && map[4][i] == symb))
                return true;
            if ((map[2][0] == symb && map[2][1] == symb && map[3][2] == symb && map[4][3] == symb) ||
                    (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb && map[3][3] == symb) ||
                    (map[1][1] == symb && map[2][2] == symb && map[3][3] == symb && map[4][4] == symb) ||
                    (map[0][1] == symb && map[1][2] == symb && map[2][3] == symb && map[3][4] == symb) ||
                    (map[3][0] == symb && map[2][1] == symb && map[1][2] == symb && map[0][3] == symb) ||
                    (map[4][0] == symb && map[3][1] == symb && map[2][2] == symb && map[1][3] == symb) ||
                    (map[3][1] == symb && map[2][2] == symb && map[1][3] == symb && map[0][4] == symb) ||
                    (map[4][1] == symb && map[3][2] == symb && map[2][3] == symb && map[1][4] == symb))
                return true;
        }
        return false;
    }

    public static boolean mapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        initMAP();
        printMap();
        while (true) {
            humanTurn();
            //printMap();
            if (checkTheWin(DOT_X)) {
                System.out.println("Победил игрок");
                break;
            }
            aiTurn();
            printMap();
            if (checkTheWin(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }
            if (mapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена!");
    }
}
