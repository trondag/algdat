package no.hiof.trondag;

import java.util.*;

public class Josephus_2
{
    /**
     * Continue around the circle eliminating every d'th number
     * until all but one number have been eliminated.
     */
    public static void main(String[] args)
    {
        // n: number of elements
        // d: skip size
        // f: first number to be removed
        int n, d, f;

        Scanner in = new Scanner(System.in);
        System.out.print("n: ");
        n = in.nextInt();
        in.nextLine();
        System.out.print("d: ");
        d = in.nextInt();
        in.nextLine();
        System.out.print("f: ");
        f = in.nextInt();

        // Indexed list storing remaining elements during removal
        Queue<Integer> L = new LinkedList<Integer>();

        // Load the initial list of numbers
        for (int i = 1; i <= n; i++)
            L.add(i);

        // Set index of first element to be removed
        int p = f - 1;

        System.out.print("The order of removal is:");

        // Treating the list as circular, remove every d'th element
        // until only one element remains
        for (int i = 0; i < p; i++){
            L.add(L.remove());
        }
        System.out.print(L.remove()+ " ");
        for (int i = 0; i < n-2; i++){
            for(int k = 0; k < d-1; k++){
                L.add(L.remove());
            }
            System.out.print(L.remove() + " ");

        }

        // Print last number remaining in list
        System.out.println("\nNumber not removed: " + L.peek());
    }
}