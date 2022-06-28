package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1791. Find Center of Star Graph
 */
public class FindCenterofStarGraph {

    public static int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet();

        for (int i = 0; i < edges.length; i++) {
            int[] arr = edges[i];
            if(!set.add(arr[0])){
                return arr[0];
            }
            if(!set.add(arr[1])){
                return arr[1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1,2},{2,3},{4,2}})); // 2
        System.out.println(findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}})); // 1

    }
}
