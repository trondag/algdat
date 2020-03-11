package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static long tidBrukt = 0;

    //////////////
    //      Har laget innstikksortering og en halvveis flettesortering selv, men quicksort og radix-sortering er hentet fra canvas.
    //      Laget en circular-queue til radix-sorteringen

    public static void main(String[] args) throws EmptyCollectionException {
        System.out.println("Velkommen! Hvor mange tall ønsker du å sortere?");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Array: ");
        fyllArray(array);
        System.out.println("\nHvilken metode?  [i]nnstikksortering, [q]uicksort, [f]lettesortering eller [r]radixsortering");
        String metode = scanner.next();
        int typeTest = hvilkenTest();
        if (typeTest == 1) {
            array = hvilkenMetode(metode, array);
            System.out.println("sortert: ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println("\nTid brukt: " + tidBrukt + "ms");
        }

        else {
            utregning(metode, size);
        }
    }

    private static int[] fyllArray(int[] array) {
        for (int i = 0; i < array.length; i++){
            array[i] = (int)Math.floor(Math.random()*array.length);
        }
        return array;
    }

    private static int[] hvilkenMetode(String metode, int[] array) throws EmptyCollectionException {
        switch (metode) {
            case "i":
                return innstikksortering(array);
            case "q":
                return quicksort(array);
            case "f":
                return flettesortering( array, 2);
            case "r":
                return radixsortering(array);
            default: {
                System.out.println("Feil input, hvilken metode?  [i]nnstikksortering, " +
                        "[q]uicksort, [f]lettesortering eller [r]radixsortering");
                hvilkenMetode(new Scanner(System.in).next(), array);
            }

        }
        return array;
    }

    private static int[] innstikksortering( int[] array) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++){
            int minsteElement = array[i];
            for (int k = i+1; k < array.length; k++){
                int midlertidigLagretElement = array[i];
                if (minsteElement > array[k]){
                        minsteElement = array[k];
                        array[i] = array[k];
                        array[k] = midlertidigLagretElement;
                }
            }

            array[i] = minsteElement;
        }
        long end = System.currentTimeMillis();
        tidBrukt = end - start;
        return array;
    }

    private static int[] quicksort( int[] array) {

        long start = System.currentTimeMillis();
        int[] result =  quickSort(array, 0, array.length-1);
        long end = System.currentTimeMillis();
        tidBrukt = end - start;
        return  result;
    }

    private static int[] flettesortering( int[] array, int faktor) {
        long start = System.currentTimeMillis();
        if (faktor > (array.length)*2){
            return array;
        }
        int min = 0;
            while (min < array.length) {
                if (faktor <= 2) {
                     if ((min + 1 != array.length) && Integer.compare(array[min], array[min + faktor - 1]) == 1) {
                        int mellomLagring = array[min + faktor - 1];
                        array[min + faktor - 1] = array[min];
                        array[min] = mellomLagring;
                    }
                } else {
                    if (array.length-1 < min+faktor-1){
                        array = quickSort(array, min, array.length-1);
                    } else {
                        array = quickSort(array, min, min + faktor - 1);
                    }
                }
                min += faktor;
            }
            long end = System.currentTimeMillis();
            tidBrukt = end - start;

        return flettesortering(array,  faktor*2);
    }


    private static int[] radixsortering( int[] array) throws EmptyCollectionException {
        long start = System.currentTimeMillis();
        int[] result = sort(array, 10);
        long end  = System.currentTimeMillis();
        tidBrukt = end - start;
        return  result;
    }

    private static int hvilkenTest(){
        System.out.println("Hvilken test?" +
                "\n[1]. Utføre selve sorteringen og skrive ut hvor lang kjøretid sorteringsmetoden bruker." +
                "\n[2]. Estimere (beregne en tilnærmet riktig verdi for) konstanten foran det høyeste " +
                "ordens leddet i uttrykket for arbeidsmengden til den valgte sorteringsmetoden.\n");
        return new Scanner(System.in).nextInt();
    }


    //////
    //   Quicksort er hentet fra Canvas

    private static int[] quickSort(int[] A, int min, int max)
    {
        // Quicksort av array med heltall

        int indexofpartition;

        if (max - min  > 0)
        {
            // Partisjonerer array
            indexofpartition = findPartition(A, min, max);

            // Sorterer venstre del
            quickSort(A, min, indexofpartition - 1);

            // Sorterer hÃ¸yre del
            quickSort(A, indexofpartition + 1, max);
        }

        return A;
    }

    private static int findPartition (int[] A, int min, int max)
    {
        int left, right;
        int temp, partitionelement;

        // Bruker *fÃ¸rste* element til Ã¥ dele opp
        partitionelement = A[min];

        left = min;
        right = max;

        // GjÃ¸r selve partisjoneringen
        while (left < right)
        {
            // Finn et element som er stÃ¸rre enn part.elementet
            while (A[left] <= partitionelement && left < right)
                left++;

            // Finn et element som er mindre enn part.elementet
            while (A[right] > partitionelement)
                right--;

            // Bytt om de to hvis ikke ferdig
            if (left < right)
            {
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }

        // Sett part.elementet mellom partisjoneringene
        temp = A[min];
        A[min] = A[right];
        A[right] = temp;

        // Returner indeksen til part.elementet
        return right;
    }


    /////////////
    //   Radix-sortering, hentet fra Canvas

    public static int[] sort(int a[], int maksAntSiffer) throws EmptyCollectionException {
        // Radixsortering av en array a med desimale heltall
        // maksAntSiffer: Maksimalt antall siffer i tallene

        int ti_i_m = 1; // Lagrer 10^m
        int n = a.length;

        // Oppretter n tomme køer
        CircularQueue[] Q = new CircularQueue[n];

        for (int i = 0; i < n; i++)
            Q[i] = new CircularQueue<>(Integer.class, n);

            // Fordeler tallene i n køer
            for (int i = 0; i < n; i++)
            {
                int siffer = (a[i] / ti_i_m) % n;
                Q[siffer].enqueue(new Integer(a[i]));
            }

            // Tømmer køene og legger tallene fortløpende tilbake i a
            int j = 0;
            for (int i = 0; i < n; i++)
                while (!Q[i].isEmpty())
                    a[j++] = (int) Q[i].dequeue();

        return a;
    }

    static void utregning(String metode, int n) throws EmptyCollectionException {
        long T = 0;
        for (int i = 0; i < 5; i++) {
            int[] array = new int[n];
            array = fyllArray(array);
            switch (metode) {
                case "i":
                    innstikksortering(array);
                case "q":
                    quicksort(array);
                case "f":
                    flettesortering(array, 2);
                case "r":
                    radixsortering(array);
            }
            T += tidBrukt;
        }
        T /= 5;
        System.out.println("snitt: " + T + "ms");

        double C = 0;

        switch (metode) {
            case "i":
                C =  (T / Math.pow( n, 2));
                System.out.println("C = " + C);
            case "q":

            case "f":

            case "r":

        }
    }

}
