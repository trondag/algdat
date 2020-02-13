package no.hiof.trondag;

public class Main {

    public static void main(String[] args) {
        System.out.println(adder(5, 5));
    }

    static int mult( int n, int m){

        if (n == 1)
            return m;

        return (m + mult(m, n - 1));
    }

    static int adder( int n, int m){
        if (n == 0)
            return m;
        m++;
        return (adder(n - 1, m));
    }


}
