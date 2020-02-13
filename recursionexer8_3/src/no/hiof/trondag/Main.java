package no.hiof.trondag;

import java.util.Scanner;

public class Main {

    private static int sum;

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 6, 4, 92, 23, 43, 34};

        System.out.println(SumOfArray(array, 2, 6));
        System.out.println("Fakultet: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fakultet(n));
        n = scanner.nextInt();

        System.out.println(SumOfSquares(n));

    }

    static int SumOfArray(int[] array, int loverIndex, int higherIndex){
        
        if (higherIndex == loverIndex){
            return sum;
        }
        sum += array[higherIndex];
        SumOfArray(array, loverIndex, higherIndex-1);
        return sum;
    }

    static int SumOfSquares(int n){
        if (n <= 1){
            return 1;
        }
        return n*n + SumOfSquares(n-1);
    }

    static int fakultet(int n){
        if (n <= 1){
            return 1;
        }
        return n*fakultet(n-1);
    }
}
