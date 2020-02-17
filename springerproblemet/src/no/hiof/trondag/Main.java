package no.hiof.trondag;

import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int sisteTrekk = 10;
    public static boolean erBackTrack = false;
    public static int antallForsøk = 0;

    public static void main(String[] args) {
        System.out.println("Størrelse: ");
        Scanner scanner = new Scanner(System.in);

        int storrelse = 5;
        los(storrelse, 1, 1);
    }

    private static void los(int storrelse, int x, int y) {
        int[][] brett = new int[storrelse][storrelse];

        flytt(brett, new Stack<int[]>(), 1, x-1, y-1);
        skrivUtRes(brett);
    }

    private static int[][] flytt(int[][] brett, Stack<int[]> stack, int antTrekk, int posX, int posY){
        brett[posY][posX] = antTrekk;
        skrivUtRes(brett);
        if (antTrekk == brett.length * brett.length){
            System.out.println("\nProgrammet fant en løsning!");
            System.out.println("Antall forsøk: " + antallForsøk);
            System.out.println("Løsning:");
            return brett;
        }
        antallForsøk++;

        System.out.print("stacksize: " + stack.size() + " antall trekk: " + antTrekk);

        //////////////////////////////////
        /// Gjør trekket
        //////////////////////////////////

        //1
        if ((posX-1 >= 0) && (posY-2 >= 0) && brett[posY-2][posX-1] == 0 && !erBackTrack){
            stack.add(new int[]{1, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX-1, posY-2);
        } else if (erBackTrack && sisteTrekk < 1
            && (posX-1 >= 0) && (posY-2 >= 0) && brett[posY-2][posX-1] == 0 ) {
            stack.add(new int[]{1, posX, posY});
            erBackTrack = false;
            return flytt(brett, stack, antTrekk + 1, posX-1, posY-2);
        }
        //2
        if ((posX+1 < brett.length) && (posY-2 >= 0) &&           brett[posY-2][posX+1] == 0 && !erBackTrack){
            stack.add(new int[]{2, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX+1, posY-2);
        } else if ((erBackTrack && sisteTrekk < 2)
            && (posX+1 < brett.length) && (posY-2 >= 0) &&           brett[posY-2][posX+1] == 0 ){
            stack.add(new int[]{2, posX, posY});
            erBackTrack = false;
            return flytt(brett, stack, antTrekk + 1, posX+1, posY-2);
        }
        //3
        if ((posX+2 < brett.length) && (posY-1 >= 0) &&           brett[posY-1][posX+2] == 0 && !erBackTrack){
            stack.add(new int[]{3, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX+2, posY-1);
        } else if ((erBackTrack && sisteTrekk < 3)
            && (posX+2 < brett.length) && (posY-1 >= 0) &&           brett[posY-1][posX+2] == 0 ){
            stack.add(new int[]{3, posX, posY});
            erBackTrack = false;
            return flytt(brett, stack, antTrekk + 1, posX+2, posY-1);
        }
        //4
        if ((posX+2 < brett.length) && (posY+1 < brett.length) && brett[posY+1][posX+2] == 0 && !erBackTrack){
            stack.add(new int[]{4, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX+2, posY+1);
        } else if ((erBackTrack && sisteTrekk < 4)
                && (posX+2 < brett.length) && (posY+1 < brett.length) && brett[posY+1][posX+2] == 0 ){
            stack.add(new int[]{4, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX+2, posY+1);
        }
        //5
        if ((posX+1 < brett.length) && (posY+2 < brett.length) && brett[posY+2][posX+1] == 0 && !erBackTrack){
            stack.add(new int[]{5, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX+1, posY+2);
        } else if ((erBackTrack && sisteTrekk < 5)
                && (posX+1 < brett.length) && (posY+2 < brett.length) && brett[posY+2][posX+1] == 0 ){
            stack.add(new int[]{5, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX+1, posY+2);
        }
        //6
        if ((posX-1 >= 0) &&           (posY+2 < brett.length) && brett[posY+2][posX-1] == 0 && !erBackTrack){
            stack.add(new int[]{6, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX-1, posY+2);
        } else if ((erBackTrack && sisteTrekk < 6)
            && (posX-1 >= 0) &&           (posY+2 < brett.length) && brett[posY+2][posX-1] == 0 ){
            stack.add(new int[]{6, posX, posY});
            erBackTrack = false;
            return flytt(brett, stack, antTrekk + 1, posX-1, posY+2);
        }
        //7
        if ((posX-2 >= 0) &&           (posY+1 < brett.length) && brett[posY+1][posX-2] == 0 && !erBackTrack){
            stack.add(new int[]{7, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX-2, posY+1);
        } else if ((erBackTrack && sisteTrekk < 7)
            && (posX-2 >= 0) &&           (posY+1 < brett.length) && brett[posY+1][posX-2] == 0 ){
            stack.add(new int[]{7, posX, posY});
            erBackTrack = false;
            return flytt(brett, stack, antTrekk + 1, posX-2, posY+1);
        }
        //8
        if ((posX-2 >= 0) &&           (posY-1 >= 0) &&           brett[posY-1][posX-2] == 0 && !erBackTrack){
            stack.add(new int[]{8, posX, posY});
            return flytt(brett, stack, antTrekk + 1, posX-2, posY-1);
        } else if ((erBackTrack && sisteTrekk < 8)
            && (posX-2 >= 0) &&           (posY-1 >= 0) &&           brett[posY-1][posX-2] == 0 ){
            stack.add(new int[]{8, posX, posY});
            erBackTrack = false;
            return flytt(brett, stack, antTrekk + 1, posX-2, posY-1);
        }
        else {
            brett[posY][posX] = 0;
            sisteTrekk = stack.peek()[0];
            erBackTrack = true;
            flytt(brett, stack, antTrekk - 1, stack.peek()[1], stack.pop()[2]);
        }

    return brett;
    }

    private static boolean erFeltedLedig(int[][] brett, Stack<int[]> stack, int posX, int posY, int i, int i2, int i3) {
        if ((posX + i < brett.length) && (posY + i2 < brett.length) && brett[posY + i2][posX + i] == 0 && !erBackTrack) {
            stack.add(new int[]{i3, posX, posY});
            return true;
        } else if ((erBackTrack && sisteTrekk < i3)
                && (posX + i < brett.length) && (posY + i2 < brett.length) && brett[posY + i2][posX + i] == 0) {
            stack.add(new int[]{i3, posX, posY});
            erBackTrack = false;
            return true;
        }
        return false;
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
        System.out.print("\n-----------------------");
    }
}
