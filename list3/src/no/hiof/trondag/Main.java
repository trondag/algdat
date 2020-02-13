package no.hiof.trondag;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// Bruker lÃ¦rebokas stack-modul. Last ned koden til egen maskin,
// legg den i en underkatalog "jsjf" og kompiler


public class Main
{
    public static boolean erPalindrom(String line)
    /**
     * Sjekker om en tegnstreng er et et palindrom. Litt fancy
     * versjon som ignorerer bÃ¥de space og smÃ¥/store bokstaver
     */
    {
        ArrayList<Character> list = new ArrayList<Character>();

        // GjÃ¸r om til smÃ¥ bokstaver og fjerner all whitespace
        line = line.toLowerCase();
        line = line.replaceAll("\\s","");

        // Legger tegnene pÃ¥ en list

        for (int i = 0; i < line.length(); i++)
            list.add((line.charAt(i)));

        for(int i = 0; i < list.size(); i++){
            if(list.remove(0) == list.remove(list.size()-1)){
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args)
    /**
     * Leser en linje fra standard input, sjekker om tegnene utgjÃ¸r
     * et palindrom.
     */
    {
        String line;
        Scanner in = new Scanner(System.in);

        System.out.print("? ");
        line = in.nextLine();

        if (erPalindrom(line))
            System.out.println("'" + line + "' er et palindrom");
        else
            System.out.println("'" + line + "' er ikke et palindrom");
    }
}