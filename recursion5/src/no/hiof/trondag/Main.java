package no.hiof.trondag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(5 / 2);
        Scanner scanner = new Scanner(System.in);
        System.out.println("skriv inn m: ");
        int m = scanner.nextInt();
        System.out.println("skriv inn n: ");
        int n = scanner.nextInt();
        System.out.println("Svar: " + ackermann(m, n));
    }

    static long ackermann(long m, long n){
        if (m == 0){
            return (n + 1);
        }
        if (n == 0){
            return ackermann(m - 1, 1);
        }
        return ackermann(m - 1, ackermann(m, n - 1));
    }
}
