package no.hiof.trondag;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

// Bruker lÃ¦rebokas stack-modul. Last ned koden til egen maskin,
// legg den i en underkatalog "jsjf" og kompiler. Husk Ã¥ legge bÃ¥de
// stÃ¥ende katalog og forelderkatalog pÃ¥ CLASSPATH slik at Java-
// kompilatoren finner modulene som inkluderes


public class Main
{
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();

        Character c;
        int l;
        String line;
        Scanner in = new Scanner(System.in);

        line = in.nextLine();
        l = line.length();

        for (int i = 0; i < l; i++)
            stack.push(line.charAt(i));
        System.out.println(erPalindrom(line, stack));
    }


    public static boolean erPalindrom(String line, Stack<Character> stack1){
        int i = 0;
        while (!stack1.empty()){
            if (!stack1.pop().equals(line.charAt(i))){
                return false;
            }
            i++;
        }
        return true;





    }
}