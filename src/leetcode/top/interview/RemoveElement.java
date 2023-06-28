package leetcode.top.interview;

import java.util.Arrays;

/**
 * 27. Remove Element (easy)
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static int removeElement1(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                k++;
            }
            if(nums[i] == val){
                nums[i] = 101;
            }
        }
        Arrays.sort(nums);
        return k;
    }

    public static void main(String[] args) {
//        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
