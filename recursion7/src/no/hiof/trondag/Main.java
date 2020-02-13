package no.hiof.trondag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Streng: \n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        snu(input, input.length());
        uordnetutvalg(input, input.length());
    }

    public static void snu(String s, int n){
        if (n <= 0){
            return;
        }
        System.out.print(s.charAt(n-1));
         snu(s, n -1);
    }

    public static void uordnetutvalg(String s, int n){
        int m = n;
        m++;
        hentUt(s, n - 1, m);
    }
    static void hentUt(String s, int n, int m){
        if (m == 0){
            return;
        }
        System.out.println(s.charAt(n-1) + s.charAt(m-2));
        hentUt(s, n, m - 1);
    }
}
