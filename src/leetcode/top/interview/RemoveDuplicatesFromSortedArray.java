package leetcode.top.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * 26. Remove Duplicates from Sorted Array (easy)
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[k] != nums[i]){
                nums[++k] = nums[i];
            }
        }
        return ++k;
    }

    public static int removeDuplicates2(int[] nums) {
        int[] arr = new int[201];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            int t = nums[i]+100;
            if(arr[t] == 0){
                nums[k] = nums[i];
                arr[t] += 1;
                k++;
            }
        }

        return k;
    }

    public int removeDuplicates1(int[] nums) {
        int k = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                nums[k] = nums[i];
                set.add(nums[i]);
                k++;
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,2}));
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
}
