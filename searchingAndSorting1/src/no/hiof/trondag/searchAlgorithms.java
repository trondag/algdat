package no.hiof.trondag;

import java.util.Scanner;

public class searchAlgorithms
{
    // Sequential, binary, and interpolation search of integer arrays

    public static boolean seqSearch(int A[], int x)
    {
        // Standard sequential search
        int n = A.length;
        for (int i = 0; i < n; i++)
            if (A[i] == x)
                return true;
        return false;
    }

    public static boolean binSearch(int A[], int x)
    {
        // Iterative binary search
        int n = A.length;
        int min = 0, max = n - 1, mid = 0;

        while (max >= min)
        {
            mid = (min + max) / 2;
            if (A[mid] == x)
                return true;
            if (x < A[mid])
                max = mid - 1;
            else
                min = mid + 1;
        }
        return false;
    }

    public static boolean binRecSearch(int A[], int x, int min, int max){

        int mid = ((A[max-1] - A[min]) / 2 ) + A[min];

        if (mid == x){
            return true;
        } else if (mid < x){
            return binRecSearch(A, x, mid, max);
        } else {
            return binRecSearch(A, x, min, mid);
        }
    }

    public static boolean tenarySearch(int A[], int x){
        int storrelse = 2;
        if (x > A[A.length - 1] || x < A[0]){
            return false;
        }
        while (storrelse > 1){
            storrelse = (int) Math.ceil(A.length/3);
            if (storrelse == 0){
                storrelse = 1;
            }

            if (x < A[storrelse]){
                int[] midlertidigArray = new int[storrelse];
                for (int i = 0; i < storrelse; i++){
                    midlertidigArray[i] = A[i];
                }
                A = midlertidigArray;
            } else if (storrelse > 1 && x < A[storrelse*2 ] ){
                int[] midlertidigArray = new int [storrelse];
                for (int i = 0; i < storrelse ; i++){
                    midlertidigArray[i] = A[i + storrelse];
                }
                A = midlertidigArray;
            } else {
                int[] midlertidigArray = new int [storrelse];
                if (storrelse > 1) {
                    for (int i = 0; i < storrelse; i++) {
                        midlertidigArray[i] = A[i + storrelse * 2];
                    }
                } else {
                    midlertidigArray = new int[1];
                    midlertidigArray[0] = A[1];
                }
                A = midlertidigArray;

            }
        }
        return (A[0] == x);
    }

    public static boolean tenRecSearch(int[] A, int x, int min, int max){
        if (x < A[0] || x > A[A.length-1]){
            return false;
        }
        int storrelse = (max - min) /3;
        if (x == A[min]){
            return true;
        }

        if (x > min && x < A[storrelse + min]){
            return tenRecSearch(A, x, min, storrelse + min);
        } else if (x == A[storrelse + min]){
            return true;
        } else if ( x < A[storrelse*2 + min]){
            return tenRecSearch(A, x, storrelse + min, storrelse*2 + min);
        } else if (x == A[storrelse*2 + min]){
            return true;
        }
        else if (x > A[storrelse*2 + min] && x < A[max-1]){
            return tenRecSearch(A, x, storrelse*2 + min, A.length);
        } else if (x == A[max-1]){
            return true;
        } else {return false;}
    }

    public static boolean interSearch(int A[], int x)
    {
        // Interpolation search
        int n = A.length;
        int min = 0, max = n - 1, mid = 0;
        float percent, step;

        while (A[min] < x && x <= A[max] && max > min)
        {
            percent = ((float) (x - A[min]))/ ((float) (A[max] - A[min]));
            step = (max - min) * percent;
            mid = min + (int) step;
            if (A[mid] == x)
                return true;
            if (x < A[mid])
                max = mid - 1;
            else
                min = mid + 1;
        }
        if (A[min] == x)
            return true;
        return false;
    }

    public static void main(String[] args){
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        System.out.println("Hvor mange tall?");
        Scanner scanner = new Scanner(System.in);
        int[] array2 = new int[scanner.nextInt()];

        for (int i = 0; i < array2.length; i++){
            array2[i] = i;
        }

        System.out.println("Hvilket tall skal finnes?");
        int x = scanner.nextInt();

        System.out.println("binært søk:");
        long startTime = System.nanoTime();
        System.out.println(binSearch(array2, x));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("tid brukt: " + duration + " / " + duration/1000000 + "ms\n\nBinært søk (rekursivt):");

        System.out.println("binært søk:");
        startTime = System.nanoTime();
        System.out.println(binSearch(array2, x));
        endTime = System.nanoTime();
        duration = (endTime - startTime);

        System.out.println("tid brukt: " + duration + " / " + duration/1000000 + "ms\n\nTernært søk:");

        startTime = System.nanoTime();
        System.out.println(tenarySearch(array2, x));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Tid brukt: " + duration + " / " + duration/1000000 + "ms\n\nTernært søk (rekursivt):");

        System.out.println(tenRecSearch(array2, x, 0, array.length));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Tid brukt: " + duration + " / " + duration/1000000 + "ms");
    }
}