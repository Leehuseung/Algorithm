package leetcode.top.interview.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 69. Majority Element (easy)
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int num : nums) {
            if (count == 0 && majority != num) {
                majority = num;
                count = 1;
            } else if (majority == num) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
    public static int majorityElement2(int[] nums) {
        int k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
            if (map.get(n) > map.getOrDefault(k, 0)) {
                k = n;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{3, 3, 3, 2, 2}));
        System.out.println(majorityElement(new int[]{3,3,3,2,2,1,1,7,7}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
