package no.hiof.trondag;

/* Enkel implementasjon av stack med heltallsarray, uten feilsjekking... */

public class IntStack
{
    private int top, max;
    private int stack[];

    public IntStack(int length)
    {
        top = 0;
        max = length;
        stack = new int[max];
    }

    public void push(int i) throws IntStackFullException {
        if (top == max)
            throw new IntStackFullException("Stacken er full");
        stack[top] = i;
        top++;
    }

    public int pop() throws IntStackEmptyException
    {
        if (top == 0)
            throw new IntStackEmptyException();
        top--;
        return(stack[top]);
    }

    public int peek()
    {
        return(stack[top-1]);
    }

    public boolean isEmpty()
    {
        return (top == 0);
    }

    public int size()
    {
        return top;
    }

    class IntStackFullException extends Throwable {
        public IntStackFullException(String stacken_er_full) {
        }
    }

    class IntStackEmptyException extends Exception {
    }
}