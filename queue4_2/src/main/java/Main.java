import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws EmptyCollectionException {
            // Leser antall tall og antall siffer fra kommandolinja
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            int m = Integer.parseInt(scanner.nextLine());

            // Beregner maks.verdi for tallene som skal sorteres
            int ti_i_m = (int) java.lang.Math.pow(10,m);
            int a[] = new int[n];
            Random R = new Random();

            // Fyller array med tilfeldige tall mellom 0 og 10^m - 1
            for (int i = 0; i < n; i++)
                a[i] = R.nextInt(ti_i_m);

            // Sorterer
            sort(a, m);

            // Skriver ut sortert array formatert i kolonner
            int linjebredde = 80;
            int tall_pr_linje = linjebredde/(m + 1);
            for (int i = 0; i < n; i++)
            {
                String format = "%" + m + "d ";
                System.out.printf(format, a[i]);
                if (((i+1) % tall_pr_linje == 0) || (i == n - 1))
                    System.out.println();
            }
        }

    public static void sort(int a[], int maksAntSiffer) throws EmptyCollectionException {
        // Radixsortering av en array a med desimale heltall
        // maksAntSiffer: Maksimalt antall siffer i tallene


        int[] tierArray = new int[10];

        int ti_i_m = 1; // Lagrer 10^m
        int n = a.length;


        for (int m = maksAntSiffer-1; m >= 0; m--)
        {
            for (int i = 0; i < a.length; i++){
                if (digitAt(a[i], m) == -1){
                    tierArray[0]++;
                    continue;
                } else {
                    tierArray[digitAt(a[i], m)]++;
                }
            }
            for (int i = 0; i < tierArray.length-1; i++){
                tierArray[i+1] += tierArray[i];
            }
            int[] b = new int[a.length];
            for (int i = a.length - 1 ; i >= 0; i--){
                int tall = digitAt(a[i], m);
                if (tall == -1){
                    tierArray[0]--;
                    b[tierArray[0]] = a[i];
                } else {
                    tierArray[tall]--;
                    b[tierArray[tall]] = a[i];
                }
            }
            a = b;
        }











        System.out.println("array: ");
        for (var i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

    }
    public static int digitAt(int tall, int plass){
            String charTall = Integer.toString(tall);
            if (charTall.length() < plass+1){
                return -1;
            } else {
                Character tallet = charTall.charAt(plass);
                return Integer.parseInt(tallet.toString());
            }
    }
}
