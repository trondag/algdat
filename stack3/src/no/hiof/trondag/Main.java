package no.hiof.trondag;

public class Main {

    public static void main(String[] args) throws IntStack.IntStackFullException, IntStack.IntStackEmptyException {

        IntStack intStack = new IntStack(5);

        intStack.push(8);
        intStack.push(3);
        intStack.push(9);
        intStack.push(2);
        intStack.push(4);
        //intStack.push(3);
        intStack.pop();
        intStack.pop();
        intStack.pop();
        intStack.pop();
        intStack.pop();
       // intStack.pop();
    }
}
