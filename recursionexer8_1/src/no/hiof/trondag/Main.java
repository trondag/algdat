package no.hiof.trondag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Det høyeste tallet må plasseres som første parameter.
        System.out.println("tall 1: ");
        Scanner scanner = new Scanner(System.in);
        int tall1 = scanner.nextInt();
        System.out.println("tall 2: ");
        int tall2 = scanner.nextInt();
        System.out.println(divisor(tall1, tall2));
    }

    static int divisor(int a, int b){
        int n;
        if ( a < b){
            n = a;
            return greatestDivisor(a, b, n);
        } else {
            n = b;
            return greatestDivisor(b, a, n);
        }
    }

    static int greatestDivisor(int a, int b, int n){
        if (a % n == 0 && b % n == 0){
            return n;
        }
        return greatestDivisor(a, b, n - 1);
    }
}
