package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1122. Relative Sort Array
 */
public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int[] table = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            table[arr1[i]] = table[arr1[i]] + 1;
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < table[arr2[i]]; j++) {
                list.add(arr2[i]);
            }
            table[arr2[i]] = 0;
        }

        for (int i = 0; i < table.length; i++) {
            if(table[i] != 0){
                for (int j = 0; j < table[i]; j++) {
                    list.add(i);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int []{2,1,4,3,9,6})); //[2,2,2,1,4,3,3,9,6,7,19]

    }
}
