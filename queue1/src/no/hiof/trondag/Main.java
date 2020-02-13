package no.hiof.trondag;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static boolean erPalindrom(String line)
    /**
     * Sjekker om en tegnstreng er et et palindrom. Litt fancy
     * versjon som ignorerer bÃ¥de space og smÃ¥/store bokstaver
     */
    {
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<Character>();
        line = line.toLowerCase();
        line = line.replaceAll("\\s","");
        for (int i = 0; i < line.length(); i++) {
            stack.push((line.charAt(i)));
            queue.add(line.charAt(i));
        }
        while(!stack.empty()){
            if (!stack.pop().equals(queue.remove())){
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