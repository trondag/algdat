package no.hiof.trondag;

import java.util.ArrayList;
import java.util.Scanner;

public class dronning
{
    public static final int MAX_N=15;

    public static int n;           // StÃ¸rrelse pÃ¥ brettet
    public static int p[];         // Permutasjonsvektor som for hver rad
    // lagrer kolonnene dronningene står i
    public static boolean brukt[]; // Merker av brukte kolonner
    public static int antLoes = 0; // Antall lÃ¸sninger funnet

    public static int antUnikeLoes = 0;

    public static void lagLoesning(int rad)
    {
        // Lager alle mulige løsninger pÃ¥ dronningproblemet fra og med
        // denne raden og ned til rad n. Det er allerede satt ut
        // dronninger på radene 1, 2, ..., rad-1

        if (rad == n+1)
            // Laget ferdig en løsning, skriver ut
            skrivLoesning();
        else
        {
            // Setter etter tur dronninger inn på alle ledige
            // kolonner i denne raden, sjekker om den kan
            // slås av dronningene ovenfor, hvis ikke går vi
            // rekursivt videre til neste rad

            for (int kol = 1; kol <= n; kol++)
            {
                if (!brukt[kol] && lovligPlassering(rad, kol))
                {
                    p[rad] = kol;
                    brukt[kol] = true;

                    lagLoesning(rad + 1);

                    brukt[kol] = false;
                }
            }
        }
    }

    public static boolean lovligPlassering(int rad, int kol)
    {
        // Sjekker om dronningene i ovenstående rader kan
        // slå utplassert dronning diagonalt

        int k1 = kol, k2 = kol;
        for (int r = rad-1; r >= 1; r--)
        {
            k1--;
            k2++;
            if (k1 >= 1 && p[r] == k1)
                return false;
            if (k2 <= n && p[r] == k2)
                return false;
        }
        return true;
    }

    public static void skrivLoesning()
    {
        for (int i = 1; i <= n; i++)
            System.out.print(p[i] + " ");
        System.out.println();
        antLoes++;

        settIArray(p);
    }

    public static void settIArray(int[] p){
        int p1[] = new int[n+1];
        int p2[] = new int[n+1];
        int p3[] = new int[n+1];
        int p4[] = new int[n+1];
        int p5[] = new int[n+1];
        int p6[] = new int[n+1];
        int p7[] = new int[n+1];

        int N = n + 1;
        for (int i = 1; i <= n; i++){
            p1[p[1]]     = i;
            p2[N - p[i]] = N - i;
            p3[N - i]    = p[i];
            p4[i]        = N - p[i];
            p5[N - p[i]] = i;
            p6[N - i]    = N - p[i];
            p7[p[i]]     = N - i;

        }
        if (tidligereLoesning(p1) || tidligereLoesning(p2) ||
                tidligereLoesning(p3) || tidligereLoesning(p4) ||
                tidligereLoesning(p5) || tidligereLoesning(p6) ||
                tidligereLoesning(p7))
            return;

        for (int i = 1; i <= n; i++)
            System.out.print(p[i] + " ");
        System.out.println();

        antUnikeLoes++;
    }
    public static boolean tidligereLoesning(int q[])
    {
        // Returnerer true hvis q representer en lÃ¸sning
        // som er *mindre enn* den vi nÃ¥ har funnet i
        // permutasjonsvektoren p. Siden vi lager lÃ¸sningene
        // i stigende rekkefÃ¸lge, vil dette sikre at vi bare
        // skriver ut den minste av lÃ¸sningene i hver gruppe
        // av lÃ¸sninger som er speilinger/rotasjoner av
        // hverandre

        int i = 1;
        while (q[i] == p[i] && i < n)
            i++;
        if (q[i] < p[i])
            return true;
        return false;
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        if (n < 1 || n > MAX_N)
        {
            System.err.println("Too low user IQ");
            System.exit(1);
        }

        p = new int[n + 1];
        brukt = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            brukt[i] = false;

        lagLoesning(1);

        System.out.println("\nAntall løsninger: " + antLoes);


        System.out.println("\nAntall unike lÃ¸sninger: " + antUnikeLoes);
    }
}