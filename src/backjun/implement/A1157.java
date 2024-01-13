package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어공부
 */
public class A1157 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[60];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String T = bf.readLine();

        for (int i = 0; i < T.length(); i++) {
            int ii = Character.getNumericValue(T.charAt(i));
            arr[ii]++;
        }

        int sum = 0;
        int index = 0;
        int dupleSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > sum){
                index = i;
                sum = arr[i];
            } else if (arr[i] != 0 && arr[i] == sum){
                dupleSum = sum;
            }
        }
        if(dupleSum == sum) {
            System.out.println("?");
            return;
        }
        char ci = (char) (index + 55);
        System.out.println(ci);
    }
}
