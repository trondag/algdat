package no.hiof.trondag;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Character> S = new Stack<Character>();
        System.out.println("Skriv inn uttrykk:");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length() ; i++) {
            if (Character.isLetter(string.charAt(i))){
            stringBuilder.append(string.charAt(i));
            } else if (S.empty()){
                S.push(string.charAt(i));
                continue;
            }
            else {
                if (S.peek().toString().equals("*") || S.peek().toString().equals("/")){
                    while(!S.empty()){
                        stringBuilder.append(S.pop());
                    }
                    S.push(string.charAt(i));
                }
                else {
                    S.push(string.charAt(i));
                }
            }
        }
        while(!S.empty()){
            stringBuilder.append(S.pop());
        }
        System.out.println(stringBuilder);
    }
}
