package no.hiof.trondag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hva vil du regne ut?");
        Scanner scanner = new Scanner(System.in);
        int tall = scanner.nextInt();

        System.out.println("Metode A:");
        long startTime = System.currentTimeMillis();
        System.out.println(metodeA(tall));
        long endTime = System.currentTimeMillis();
        System.out.println("Tidsforbruk: " +(endTime - startTime));
        System.out.println("\nMetode B:");
        startTime = System.currentTimeMillis();
        System.out.println(metodeB(tall));
        endTime = System.currentTimeMillis();
        System.out.println("Tidsforbruk: " +(endTime - startTime));
        System.out.println("\nMetode C:");
        startTime = System.currentTimeMillis();
        System.out.println(metodeC(tall));
        endTime = System.currentTimeMillis();
        System.out.println("Tidsforbruk: " +(endTime - startTime));

    }

    static int metodeA(int n){
        int sum = 0;
        for (int i = 1 ; i <= n ; i++){
            sum += i;
        }
        return sum;
    }

    static int metodeB(int n){
        if (n == 0){return 0;}
        return (n + metodeB(n-1));
    }

    static int metodeC(int n){
        return n*(n+1)/2;
    }

    /*
    Formelen er enklest å programmere.
    Løkka er likevel enklest å forstå for en som ikke kan matte.

    Vanskelig å si hvem som er raskest, da rekursjonen fører til stackoverflow
     */
}
