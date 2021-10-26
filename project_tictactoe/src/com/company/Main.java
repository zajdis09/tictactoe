package com.company;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static String[] board1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8",};
    private static boolean run = true;
    private static byte kolo = 0;
    private static int[][] vyhernikombinace = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 4, 8},
            {2, 4, 6},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
    };

    private static void hracipole() {
        System.out.println(board1[0] + " | " + board1[1] + " | " + board1[2]);
        System.out.println(board1[3] + " | " + board1[4] + " | " + board1[5]);
        System.out.println(board1[6] + " | " + board1[7] + " | " + board1[8]);
    }

    private static void tahX() {
        System.out.println("Tah hráče X: ");
        int printboard = sc.nextInt();
        board1[printboard] = "X";
        hracipole();
        kontrolaX();
    }

    private static void tahO() {
        System.out.println("Tah hráče O: ");
        int printboard = sc.nextInt();
        board1[printboard] = "O";
        hracipole();
        kontrolaO();
    }

    private static void kontrolaX() {
        if (kolo < 5) {
            for (int i = 0; i < 2; i++) {
                String Check = "X";
                for (int j = 0; j < vyhernikombinace.length; j++) {
                    if (board1[vyhernikombinace[j][0]] == Check && board1[vyhernikombinace[j][1]] == Check && board1[vyhernikombinace[j][2]] == Check
                    ) {
                        konec();
                        Main.run = false;
                        return;
                    }
                }
            }
        }
    }

    private static void kontrolaO() {
        if (kolo < 5) {
            for (int i = 0; i < 2; i++) {
                String Check0 = "O";
                for (int j = 0; j < vyhernikombinace.length; j++) {
                    if (board1[vyhernikombinace[j][0]] == Check0 && board1[vyhernikombinace[j][1]] == Check0 && board1[vyhernikombinace[j][2]] == Check0
                    ) {
                        konec1();
                        Main.run = false;
                        return;
                    }
                }
            }
        }
    }

    private static void konec() {
        System.out.println("Vyhrál hráč X");
    }

    private static void konec1() {
        System.out.println("Vyhral hrac O");
    }


    public static void main(String[] args) {
        hracipole();
        int switching = 0;
        switching = 1;
        while (run) {
            if (switching == 1) {
                if (kolo < 5) {
                    System.out.println("Kolo: " + kolo);
                    switching = 2;
                    tahX();
                    kolo++;
                }
                if (switching == 2) {
                    if (kolo < 5) {
                        System.out.println("Kolo: " + kolo);
                        switching = 1;
                        if (kolo <= 2) {
                            tahO();
                        }
                    }
                }
                if (kolo == 5) {
                    run = false;
                }
                if (kolo == 4) {
                    System.out.println("Je to remíza");
                    run = false;
                }
            }
        }
    }
}

