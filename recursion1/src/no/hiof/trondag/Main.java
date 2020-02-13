package no.hiof.trondag;

import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static boolean erPalindrom(String line)
    /**
     * Sjekker om en tegnstreng er et et palindrom. Litt fancy
     * versjon som ignorerer bÃ¥de space og smÃ¥/store bokstaver
     */
    {
        Stack<Character> stack = new Stack<Character>();

        // GjÃ¸r om til smÃ¥ bokstaver og fjerner all whitespace
        line = line.toLowerCase();
        line = line.replaceAll("\\s","");

        // Legger tegnene pÃ¥ en stack

        for (int i = 0; i < line.length(); i++)
            stack.push(new Character(line.charAt(i)));

        // Sjekker om lest linje er er palindrom

        int i = 0;
        return bothSidesEqual(line, stack, i);


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

    public static boolean bothSidesEqual(String line, Stack<Character> stack,int i){
        System.out.println("line: "+ line.charAt(i) + "   stack: "+ stack.peek());
        if (line.charAt(i) != stack.pop()) {
            return false;
        }
        if (!stack.isEmpty()){
            i++;
            bothSidesEqual(line, stack, i);
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
