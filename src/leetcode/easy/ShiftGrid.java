package leetcode.easy;

import java.util.*;
import java.util.List;

/**
 * 1260. Shift 2D Grid
 */
public class ShiftGrid {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();

        LinkedList<Integer> link = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                link.add(grid[i][j]);
            }
        }

        for (int i = 0; i < k; i++) {
            Integer num = link.getLast();
            link.removeLast();
            link.addFirst(num);
        }

        for (int i = 0; i < grid.length; i++) {
            List<Integer> qq = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                int num = link.poll();
                qq.add(num);
            }
            list.add(qq);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1));
    }
}
