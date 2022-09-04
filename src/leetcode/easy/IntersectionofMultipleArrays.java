package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2248. Intersection of Multiple Arrays
 */
public class IntersectionofMultipleArrays {

    public static List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int[] table = new int[1001];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int num = nums[i][j];
                table[num] = table[num] + 1;
            }
        }

        for (int i = 0; i < table.length; i++) {
            if(table[i] == nums.length) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}}));
    }
}
