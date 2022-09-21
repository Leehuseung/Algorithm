package leetcode.easy;

import java.util.*;

/**
 * 349. Intersection of Two Arrays
 */
public class IntersectionofTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            if(set.contains(nums1[i])){
                list.add(nums1[i]);
                set.remove(nums1[i]);
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,2,2,1}, new int[]{2,2})));
    }
}
