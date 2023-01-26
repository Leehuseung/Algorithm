package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 2418. Sort the People
 */
public class SortthePeople {
    public static String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        for (int i = heights.length-1; i >= 0; i--) {
            names[heights.length-i-1] = map.get(heights[i]);
        }
        return names;
    }
    public static void main(String[] args) {

    }
}
