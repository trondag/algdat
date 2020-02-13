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
            String a[] = new String[n];
            Random R = new Random();

            // Fyller array med tilfeldige tall mellom 0 og 10^m - 1
            for (int i = 0; i < n; i++)
                a[i] = String.valueOf(R.nextInt(ti_i_m));

            // Sorterer
            radixSort(a, m);

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

    public static String[] radixSort(String a[], int maksAntSiffer) throws EmptyCollectionException {
        ArrayList<CircularArrayQueue> arrayList = new ArrayList<CircularArrayQueue>(26);
        for (int i = 0; i < 26; i++){
            CircularArrayQueue<String> circularArrayQueue = new CircularArrayQueue<String>();
            arrayList.add(circularArrayQueue);
        }
        System.out.println("a".hashCode() - 97);

        for (int l = maksAntSiffer; l >= 0; l--) {
            stroUt(a, arrayList, l);
            a = leggIArray(a.length, arrayList);
        }

        return a;

    }

    private static void stroUt(String[] a, ArrayList<CircularArrayQueue> arrayList, int k) {
        for (int i = 0; i < a.length; i++){
            Character letter = a[i].charAt(k);
            int hash = letter.hashCode();
            int hvilkenKo = hash - 97;
            CircularArrayQueue ko = arrayList.get(hvilkenKo);
            ko.enqueue(a[i]);
        }
    }

    private static String[] leggIArray(int length, ArrayList<CircularArrayQueue> arrayList) throws EmptyCollectionException {
        String[] a = new String[length];
        int k = 0;
        for (int i = 0; i < 26; i++ ){
            while(!arrayList.get(i).isEmpty()){
                a[k] = arrayList.get(i).dequeue().toString();
                k++;
            }
        }
        return a;
    }
}
