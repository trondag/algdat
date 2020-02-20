package no.hiof.trondag;

import java.util.Random;

public class labyrint
{
    // Verdiene som kan lagres i labyrinten
    private static int FRI = 1, STENGT = 0, BRUKT = 2, VEI = 3;

    // StÃ¸rrelse pÃ¥ labyrint og 2D-tabell som lagrer labyrinten
    private static int n;
    private static int L[][];

    public static boolean finnVei(int i, int j)
    {
        // Leter rekursivt etter en vei gjennom labyrinten fra rute
        // (i,j) til rute (n-1,n-1).
        //
        // Returnerer true hvis vi fant en slik vei, false ellers

        // Bunn i rekursjonen: Ferdig hvis vi er i nedre hÃ¸yre hjÃ¸rne
        if (i == n-1 && j == n-1)
        // SPRINGERPROBLEMET mÃ¥ her ha et annet stoppkriterium
        {
            // Markerer at siste rute i labyrinten ligger pÃ¥ veien som
            // er funnet, og returnerer true
            L[i][j] = VEI;
            return true;
        }

        // Markerer at rute (i,j) nÃ¥ er oppsÃ¸kt
        L[i][j] = BRUKT;
        // I SPRINGERPROBLEMET mÃ¥ vi her i tillegg lagre bÃ¥de antall
        // flytt som er gjort frem til nÃ¥, og hvike flytt som er gjort
        // for Ã¥ komme hit.

        // PrÃ¸ver alle fire mulige lovlige veier videre fra rute(i,j):
        // HÃ˜YRE, NED, VENSTRE, OPP

        // For Ã¥ lÃ¸se SPRINGERPROBLEMET, mÃ¥ koden her utvides til Ã¥
        // hÃ¥ndtere alle de Ã¥tte mulige lovlige stegene som en
        // springer kan ta fra rute (i,j)

        // HÃ˜YRE
        // Sjekker om det er lovlig Ã¥ gÃ¥ til hÃ¸yre
        if (j < n-1 && L[i][j+1] == FRI)
        {
            // PrÃ¸ver Ã¥ finne vei videre rekursivt fra hÃ¸yre naborute
            if (finnVei(i,j+1))
            {
                // Her vet vi at det ble funnet en vei gjennom
                // labyrinten fra rute (i,j). Merker av at (i,j)
                // ligger pÃ¥ denne veien og stopper deretter videre
                // leting etter vei ved Ã¥ returnere true

                L[i][j] = VEI;
                return true;
            }
        }

        // NED
        if (i < n-1 && L[i+1][j] == FRI)
        {
            if (finnVei(i+1,j))
            {
                L[i][j] = VEI;
                return true;
            }
        }

        // VENSTRE
        if (j > 0 && L[i][j-1] == FRI)
        {
            if (finnVei(i,j-1))
            {
                L[i][j] = VEI;
                return true;
            }
        }

        // OPP
        if (i > 0 && L[i-1][j] == FRI)
        {
            if (finnVei(i-1,j))
            {
                L[i][j] = VEI;
                return true;
            }
        }

        // Hvis vi kommer hit i koden, fantes det ingen vei gjennom
        // labyrinten fra rute (i,j), returnerer false

        return false;

        // I SPRINGERPROBLEMET mÃ¥ dette siste tilfellet, der vi ikke
        // finner noen lovlig lÃ¸sning med start i rute (i,j),
        // behandles litt anderledes. I labyrinten er det ingen vits i
        // Ã¥ gÃ¥ tilbake til en rute der vi har vÃ¦rt fÃ¸r. I
        // springerproblemet er det ikke slik, der mÃ¥ vi nÃ¥ markere at
        // ruten er blitt ledig igjen, slik at den kan brukes pÃ¥ nytt
        // i senere forsÃ¸k pÃ¥ Ã¥ bygge ut en lÃ¸sning. Ã˜vrig
        // datastruktur som brukes til Ã¥ lagre lÃ¸sningen mÃ¥ ogsÃ¥
        // oppdateres slik at dette steget som ikke ledet til lÃ¸sning
        // blir fjernet.
    }

    public static void main(String argv[])
    {

        // Leser stÃ¸rrelsen pÃ¥ labyrinten og prosentandel blokkerte ruter
        System.out.print("n?: ");
        n = Integer.parseInt(System.console().readLine());
        System.out.print("% blokkerte ruter?: ");
        int prosent = Integer.parseInt(System.console().readLine());
        if (n < 1 || prosent < 0 || prosent >= 100)
        {
            System.out.println("Bruker inkompetent. Avslutter.");
            System.exit(0);
        }

        // Oppretter 2D-tabell som lagrer labyrinten
        L = new int[n][n];

        // Fyller labyrinten L med tilfeldig blokkerte ruter
        Random R = new Random();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (R.nextInt(100) < prosent + 1)
                    L[i][j] = STENGT;
                else
                    L[i][j] = FRI;

        // Leter etter vei fra Ã¸vre venstre hjÃ¸rne

        boolean funnetVei = finnVei(0, 0);

        // Skriver ut labyrinten (og evt. funnet vei)
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (L[i][j] == VEI)
                    System.out.print('*');
                else
                    System.out.print(L[i][j]);
            }
            System.out.println("");
        }

        System.out.println("");
        if (!funnetVei)
            System.out.println("Fant ingen vei gjennom labyrinten");

    }
}