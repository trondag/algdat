package no.hiof.trondag;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    int[] tall = new int[]{1, 2, 3, 4, 8, 9, 7, 2, 5, 6, 2, 1, 7, 2, 8, 4, 6, 9};
        int [] sortert = CountingSort.sort(tall);

        for (int i = 0; i < sortert.length; i++){
            System.out.println(sortert[i]);
        }
    }

    public static class CountingSort {
        public static int[] sort(int[] tall){

            int max = 0;

            for (int i = 0; i < tall.length; i++){
                if (tall[i] > max){
                    max = tall[i];
                }
            }

            int[] countStoring = new int[max+1];

            for (int i = 0; i < countStoring.length ; i++){
                for (int k = 0; k < tall.length; k++){
                    if (tall[k] == i){
                        countStoring[i] += 1;
                    }
                }
            }
            int k = 0;
            for (int i = 0; i < countStoring.length ; i++){
                while ( countStoring[i] != 0){
                    tall[k] = i;
                    countStoring[i]--;
                    k++;
                }
            }

            return tall;
        }
    }
}
