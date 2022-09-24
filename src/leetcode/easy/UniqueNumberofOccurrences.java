package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 */
public class UniqueNumberofOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        int[] table = new int[2002];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                int index = Math.abs(arr[i]) + 1000;
                table[index] = table[index] + 1;
            } else {
                table[arr[i]] = table[arr[i]] + 1;
            }

        }

        for (int i = 0; i < table.length; i++) {
            int num = table[i];
            if(num < 0){
                num = Math.abs(num) + 1000;
            }
            if(num != 0 && set.contains(num)){
                return false;
            }
            set.add(num);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }
}
