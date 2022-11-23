package leetcode.easy;

import java.util.*;

/**
 * 496. Next Greater Element I
 */
public class NextGreaterElementI {

    //O(n^2)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        int[] table = new int[10001];

        for (int i = 0; i < table.length; i++) {
            table[i] = -1;
        }

        for (int i = 0; i < nums2.length ; i++) {
            int num = nums2[i];
            for (int j = i+1; j < nums2.length; j++) {
                if(num < nums2[j]){
                    table[num] = nums2[j];
                    break;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = table[nums1[i]];
        }

        return answer;
    }

    //O(n)
    public static int[] bestNextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}))); // -1,3,-1
        System.out.println(Arrays.toString(bestNextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}))); // -1,3,-1
    }
}
