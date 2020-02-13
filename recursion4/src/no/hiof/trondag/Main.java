package no.hiof.trondag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n: ");
        int int1 = scanner.nextInt();

        for(int n = 0; n < int1; n++){
            for (int m = 0; m < n; m++){
                System.out.println(beregn(n, m)+ " ");
            }
        }
    }

    static int beregn(int n, int m){
        if (n == 0 || m == n){
            return 1;
        }
        return beregn(n - 1, m) + beregn(n-1, m-1);
    }
}
