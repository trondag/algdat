package no.hiof.trondag;

import java.util.Random;
import java.util.Scanner;

class radixSort
        {
            public static void sort(char a[], int maksAntSiffer) throws EmptyCollectionException {
                // Radixsortering av en array a med desimale heltall
                // maksAntSiffer: Maksimalt antall siffer i tallene

                int ti_i_m = 1; // Lagrer 10^m
                int n = a.length;

                // Oppretter 10 tomme kÃ¸er
                CircularArrayQueue<Character>[] Q =
                        (CircularArrayQueue<Character>[])(new CircularArrayQueue[10]);

                for (int i = 0; i < 26; i++)
                    Q[i] = new CircularArrayQueue<Character>();

                // Sorterer på et og et siffer, fra høyre mot venstre

                for (int m = 0; m < maksAntSiffer; m++)
                {
                    // Fordeler tallene i 10 køer
                    for (int i = 0; i < n; i++)
                    {
                        int siffer = (a[i] / ti_i_m) % 26;
                        Q[siffer].enqueue(new Character (a[i]));
                    }

                    // Tømmer køene og legger tallene fortløpende tilbake i a
                    int j = 0;
                    for (int i = 0; i < 10; i++)
                        while (!Q[i].isEmpty())
                            a[j++] =  Q[i].dequeue();

                    // Beregner 10^m for neste iterasjon
                    ti_i_m *= 10;
                }
            }

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

        }
