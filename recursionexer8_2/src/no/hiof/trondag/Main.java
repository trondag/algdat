package no.hiof.trondag;

import java.util.Scanner;

public class Main {
    static boolean prim = true;

    public static void main(String[] args) {
        System.out.println("Skriv tall:");
        Scanner scanner = new Scanner(System.in);
        int tall1 = scanner.nextInt();
        int n = tall1;

        isPrime(tall1, n);
        if (prim){
            System.out.println(tall1 + " er et primtall");
        } else {
            System.out.println(tall1 + " er ikke et primtall");
        }
    }

    static void isPrime(int tall, int n){
        if ( n == 1){
            return;
        }
        if (tall == n){
            isPrime(tall, n-1);
        } else if (tall % n == 0){
            prim =false;
        }
        isPrime(tall, n - 1);
    }

    static int prime(int y,int i) {
        if(i < y) {
            if(y % i != 0) {
                return(prime(y, ++i));
            }
            else {
                return 0;
            }
        }
        return 1;
    }
}
