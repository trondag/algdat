package no.hiof.trondag;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Størrelse: ");
        Scanner scanner = new Scanner(System.in);

        int storrelse = 8;
        los(storrelse, 4, 0);
    }

    private static void los(int storrelse, int x, int y) {
        int[][] brett = new int[storrelse][storrelse];
        Random rand = new Random();
        int startposisjonY = rand.nextInt(storrelse);
        int startposisjonX = rand.nextInt(storrelse);

        flytt(brett, 1, x, y);
        skrivUtRes(brett);
    }

    private static int[][] flytt(int[][] brett, int antTrekk, int posX, int posY){
        brett[posY][posX] = antTrekk;
        skrivUtRes(brett);
        if (antTrekk >= brett.length * brett.length){
            return brett;
        }

        //////////////////////////////////
        /// Gjør trekket
        //////////////////////////////////

        if ((posX-1 >= 0) &&            (posY-2 >= 0) &&           brett[posY-2][posX-1] == 0){
            return flytt(brett, antTrekk + 1, posX-1, posY-2);
        }if ((posX+1 < brett.length) && (posY-2 >= 0) &&           brett[posY-2][posX+1] == 0){
            return flytt(brett, antTrekk + 1, posX+1, posY-2);
        }if ((posX+2 < brett.length) && (posY-1 >= 0) &&           brett[posY-1][posX+2] == 0){
            return flytt(brett, antTrekk + 1, posX+2, posY-1);
        }if ((posX+2 < brett.length) && (posY+1 < brett.length) && brett[posY+1][posX+2] == 0){
            return flytt(brett, antTrekk + 1, posX+2, posY+1);
        }if ((posX+1 < brett.length) && (posY+2 < brett.length) && brett[posY+2][posX+1] == 0){
            return flytt(brett, antTrekk + 1, posX+1, posY+2);
        }if ((posX-1 >= 0) &&           (posY+2 < brett.length) && brett[posY+2][posX-1] == 0){
            return flytt(brett, antTrekk + 1, posX-1, posY+2);
        }if ((posX-2 >= 0) &&           (posY+1 < brett.length) && brett[posY+1][posX-2] == 0){
            return flytt(brett, antTrekk + 1, posX-2, posY+1);
        }if ((posX-2 >= 0) &&           (posY-1 >= 0) &&           brett[posY-1][posX-2] == 0){
            return flytt(brett, antTrekk + 1, posX-2, posY-1);
        } else {

        }

    return brett;
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
        System.out.print("\n----------------");
    }
}
