package no.hiof.trondag;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] array = permutasjonGammelMetode(10);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        System.out.println(array[5]);
        System.out.println(array[6]);
        System.out.println(array[7]);
        System.out.println(array[8]);
        System.out.println(array[9]);
        ArrayList<int[]> arrayList = permuteringMedRekursjon(4);
        System.out.println("permuteringer: ");
        for (int[] enArray: arrayList
             ) {
            System.out.println("- ");
            for(int i = 0; i < enArray.length; i++){
                System.out.print(enArray[i]+", ");
            }
        }

    }


    static int[] permutasjonGammelMetode(int n){
        int[] array = new int[n];
        int[] brukt = new int[n+1];
        int randomkall = 0;

        for(int i = 0; i < n; i++){

            boolean finnesfrafør = false;
            Random rand = new Random();
            int int_random = rand.nextInt(n+1);
            randomkall++;
            array[i] = int_random;
            for(int k = 0; k < brukt.length; k++){
                if (array[i] == brukt[k]){
                    i--;
                    finnesfrafør = true;
                    break;
                }
            }
            if (!finnesfrafør)
            brukt[i] = int_random;

        }
        System.out.println("randomkall: "+ randomkall);
        return array;
    }
    static ArrayList<int[]> permuteringMedRekursjon( int n){
        final int[] array = new int[n];
        ArrayList<int[]> permuteringer = new ArrayList<int[]>();

        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }

        permuteringer.add(array);
        int teller = 0;

        for (int i = 0; i < n-1 ; i++){
            byttOmRekursiv(array,permuteringer, i, 1+i, n, teller);
        }


return permuteringer;

    }
    private static int[] byttOmRekursiv(int[] startArray, ArrayList<int[]> permutasjonene, int i2, int i3, int n, int teller) {
        if (permutasjonene.size() == n*(i2+1+i2+i2)){
            return startArray;
        }
        int temp;
        int[] tempArray = new int[startArray.length];
        if (i2 == 0) {
            System.arraycopy(startArray, 0, tempArray, 0, startArray.length);
        } else if (i2 >= 1){
            System.arraycopy(permutasjonene.get(teller), 0, tempArray, 0, permutasjonene.get(i3).length);
        }
        temp = tempArray[i2];
        tempArray[i2] = tempArray[i3];
        tempArray[i3] = temp;
        permutasjonene.add(tempArray);
        if (i3 == n-1){
            teller++;
            i3 = i2;
        }
        if (teller >= n+1){
            i3 = 3;
        }
        if (teller > 3 && Arrays.equals(tempArray, startArray)){
            System.arraycopy(permutasjonene.get(0), 0, tempArray, 0, startArray.length);
            temp = tempArray[n-2];
            tempArray[n-2] = tempArray[n-1];
            tempArray[n-1] = temp;
            permutasjonene.remove(permutasjonene.size()-1);
            permutasjonene.add(tempArray);
            i2 = 2;
            i3 = 3;
        }
        if (n-2 == i2){
            return byttOmRekursiv(startArray, permutasjonene, i2, i3, n, teller);
        }
        return byttOmRekursiv(startArray, permutasjonene, i2, i3+1, n, teller);
    }
}
