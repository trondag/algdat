package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Velkommen! Hvor mange tall ønsker du å sortere?");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Array: ");
        for (int i = 0; i < array.length; i++){
            array[i] = (int)Math.floor(Math.random()*size);
            System.out.print(array[i]);
        }
        System.out.println("\nHvilken metode?  [i]nnstikksortering, [q]uicksort, [f]lettesortering eller [r]radixsortering");
        String metode = scanner.next();
        array = hvilkenMetode(metode, array);
        System.out.println("sortert: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
    }

    public static int[] hvilkenMetode(String metode, int[] array) {
        switch (metode) {
            case "i":
                return innstikksortering(hvilkenTest(), array);
            case "q":
                return quicksort(hvilkenTest(), array);
            case "f":
                return flettesortering(hvilkenTest(), array);
            case "r":
                return radixsortering(hvilkenTest(), array);
            default: {
                System.out.println("Feil input, hvilken metode?  [i]nnstikksortering, " +
                        "[q]uicksort, [f]lettesortering eller [r]radixsortering");
                hvilkenMetode(new Scanner(System.in).next(), array);
            }

        }
        return array;
    }

    private static int[] innstikksortering(int hvilkenTest, int[] array) {
        for (int i = 0; i < array.length; i++){
            int minsteElement = array[i];
            int midlertidigLagretElement = array[i];
            for (int k = i; k < array.length; k++){
                if (minsteElement > array[k]){
                        minsteElement = array[k];
                        array[i] = minsteElement;
                        array[k] = midlertidigLagretElement;
                }
            }

            array[i] = minsteElement;
        }
        return array;
    }

    private static int[] quicksort(int hvilkenTest, int[] array) {
        return array;
    }

    private static int[] flettesortering(int hvilkenTest, int[] array) {
        return array;
    }

    private static int[] radixsortering(int hvilkenTest, int[] array) {
        return array;
    }

    public static int hvilkenTest(){
        System.out.println("Hvilken test?" +
                "\n[1]. Utføre selve sorteringen og skrive ut hvor lang kjøretid sorteringsmetoden bruker." +
                "\n[2]. Estimere (beregne en tilnærmet riktig verdi for) konstanten foran det høyeste " +
                "ordens leddet i uttrykket for arbeidsmengden til den valgte sorteringsmetoden.\n");
        return new Scanner(System.in).nextInt();
    }

}
