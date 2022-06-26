package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateTargetArrayintheGivenOrder {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] arr = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < index.length; i++) {
            list.add(index[i],nums[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(new int[]{0,1,2,3,4} , new int[]{0,1,2,2,1}))); // [0,4,1,3,2]
        System.out.println(Arrays.toString(createTargetArray(new int[]{1,2,3,4,0} , new int[]{0,1,2,3,0}))); // [0,1,2,3,4]
    }
}
