package no.hiof.trondag;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    // Verdiene som kan lagres i labyrinten
    private static int FRI = 1, STENGT = 0, BRUKT = 2, VEI = 3,  VENSTRE = 4, HOYRE = 5, OPP = 6, NED = 7;

    // Størrelse på labyrint og 2D-tabell som lagrer labyrinten
    private static int n;
    private static int L[][];

    public static boolean finnVei(int i, int j)
    {
        // Leter rekursivt etter en vei gjennom labyrinten fra rute
        // (i,j) til rute (n-1,n-1).
        //
        // Returnerer true hvis vi fant en slik vei, false ellers

        // Bunn i rekursjonen: Ferdig hvis vi er i nedre høyre hjørne
        if (i == n-1 && j == n-1)
        // SPRINGERPROBLEMET må her ha et annet stoppkriterium
        {
            // Markerer at siste rute i labyrinten ligger på veien som
            // er funnet, og returnerer true
            L[i][j] = VEI;
            return true;
        }

        // Markerer at rute (i,j) nå er oppsøkt
        L[i][j] = BRUKT;
        // I SPRINGERPROBLEMET må vi her i tillegg lagre både antall
        // flytt som er gjort frem til nå, og hvike flytt som er gjort
        // for å komme hit.

        // Prøver alle fire mulige lovlige veier videre fra rute(i,j):
        // HØYRE, NED, VENSTRE, OPP

        // For å løse SPRINGERPROBLEMET, må koden her utvides til å
        // håndtere alle de åtte mulige lovlige stegene som en
        // springer kan ta fra rute (i,j)


        // HØYRE
        if (j < n-1 && L[i][j+1] == FRI)
        {
            if (finnVei(i,j+1))
            {
                L[i][j] = HOYRE;
                System.out.println("("+i+","+j+")");
                return true;
            }
        }
        // NED
        if (i < n-1 && L[i+1][j] == FRI)
        {
            if (finnVei(i+1,j))
            {
                L[i][j] = NED;
                System.out.println("("+i+","+j+")");
                return true;
            }
        }
        // VENSTRE
        if (j > 0 && L[i][j-1] == FRI)
        {
            if (finnVei(i,j-1))
            {
                L[i][j] = VENSTRE;
                System.out.println("("+i+","+j+")");
                return true;
            }
        }
        // OPP
        if (i > 0 && L[i-1][j] == FRI)
        {
            if (finnVei(i-1,j))
            {
                L[i][j] = OPP;
                System.out.println("("+i+","+j+")");
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

        // Leser størrelsen på labyrinten og prosentandel blokkerte ruter
        Scanner scanner = new Scanner(System.in);
        System.out.print("n?: ");
        n = scanner.nextInt();
        System.out.print("% blokkerte ruter?: ");
        int prosent = scanner.nextInt();
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
                else if (L[i][j] == VENSTRE){
                    System.out.print('<');
                }
                else if (L[i][j] == HOYRE){
                    System.out.print('>');
                }
                else if (L[i][j] == OPP){
                    System.out.print('^');
                }
                else if (L[i][j] == NED){
                    System.out.print('v');
                }
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