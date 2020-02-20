package no.hiof.trondag;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int antallforsok = 0;
    public static boolean svarFunnet = false;

    public static void main(String[] args) {
        System.out.println("Størrelse: ");
        Scanner scanner = new Scanner(System.in);

        int storrelse = 7;
        los(storrelse, 2, 2);
    }

    private static void los(int storrelse, int x, int y) {
        int[][] brett = new int[storrelse][storrelse];
        flytt(brett, 1, x-1, y-1);
    }

    private static void flytt(int[][] brett, int antTrekk, int posX, int posY){
        brett[posY][posX] = antTrekk;
        if (antTrekk == brett.length * brett.length){
            System.out.println("\nProgrammet fant en løsning!");
            System.out.println("Antall forsøk: " + antallforsok);
            System.out.println("Løsning:");
            skrivUtRes(brett);
            svarFunnet = true;
        }
        antallforsok++;

        if(!svarFunnet) {
            if ((posX + 2 < brett.length) && (posY - 1 >= 0) && brett[posY - 1][posX + 2] == 0) {
                flytt(brett, antTrekk + 1, posX + 2, posY - 1);
            }
            if ((posX + 2 < brett.length) && (posY + 1 < brett.length) && brett[posY + 1][posX + 2] == 0) {
                flytt(brett, antTrekk + 1, posX + 2, posY + 1);
            }
            if ((posX + 1 < brett.length) && (posY + 2 < brett.length) && brett[posY + 2][posX + 1] == 0) {
                flytt(brett, antTrekk + 1, posX + 1, posY + 2);
            }
            if ((posX - 1 >= 0) && (posY + 2 < brett.length) && brett[posY + 2][posX - 1] == 0) {
                flytt(brett, antTrekk + 1, posX - 1, posY + 2);
            }
            if ((posX - 2 >= 0) && (posY + 1 < brett.length) && brett[posY + 1][posX - 2] == 0) {
                flytt(brett, antTrekk + 1, posX - 2, posY + 1);
            }
            if ((posX - 2 >= 0) && (posY - 1 >= 0) && brett[posY - 1][posX - 2] == 0) {
                flytt(brett, antTrekk + 1, posX - 2, posY - 1);
            }
            if ((posX - 1 >= 0) && (posY - 2 >= 0) && brett[posY - 2][posX - 1] == 0) {
                flytt(brett, antTrekk + 1, posX - 1, posY - 2);
            }
            if ((posX + 1 < brett.length) && (posY - 2 >= 0) && brett[posY - 2][posX + 1] == 0) {
                flytt(brett, antTrekk + 1, posX + 1, posY - 2);
            }
            brett[posY][posX] = 0;
        }
    }

    private static void skrivUtRes(int[][] brett) {
        for(int i = 0; i < brett.length; i++){
            System.out.println();
            for(int j = 0; j < brett.length; j++){
                System.out.print(brett[i][j]+ " ");
                if (brett[i][j] < 10){
                    System.out.print(" ");
                }
            }
        }
    }
}
