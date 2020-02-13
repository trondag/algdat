package no.hiof.trondag;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(44);
        stack.push(23);
        stack.push(97);
        stack.push(45);
        stack.push(12);
        stack.push(87);
        stack.push(23);

        System.out.println(stack);

        System.out.println(tredjeElement(stack));

        System.out.println(stack);

        System.out.println("Tester metode nummer to (sjekker verdi i bunnen)");

        System.out.println(stack);

        System.out.println("Element i bunnen: " + sisteElement(stack));

        System.out.println(stack);

        System.out.println("Tester å fjerne et element fra stacken");

        System.out.println(stack);

        fjernElementer(stack, 23);

        System.out.println(stack);


    }
    public static int tredjeElement(Stack<Integer> stack){
        Stack<Integer> mellomStack = new Stack<Integer>();
        int retur;
        for (int i = 0; i < 2; i++){
            if(!stack.empty()){
                mellomStack.push(stack.pop());
            } else {
                return 0;
            }
        } if (!stack.empty()) {
            retur = stack.peek();
        } else {
            return 0;
        }

        while (!mellomStack.empty()){
            stack.push(mellomStack.pop());
        }
        return retur;
    }
    public static int sisteElement(Stack<Integer> stack){
        Stack<Integer> bytteStack = new Stack<Integer>();
        if (stack.empty()) return 0;
        while(!stack.empty()){
            bytteStack.push(stack.pop());
        }
        int retur = bytteStack.peek();
        while(!bytteStack.empty()){
            stack.push(bytteStack.pop());
        }
        return retur;
    }
    public static void fjernElementer(Stack<Integer> stack, int element){
        Stack<Integer> bytteStack = new Stack<Integer>();
        while (!stack.empty()) {
            if(stack.peek() == element){
                stack.pop();
            } else {
                bytteStack.push(stack.pop());
            }
        }
        while (!bytteStack.empty()){
            stack.push(bytteStack.pop());
        }
    }
}
