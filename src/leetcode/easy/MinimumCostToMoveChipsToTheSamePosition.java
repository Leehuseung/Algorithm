package leetcode.easy;

/**
 * 1217. Minimum Cost to Move Chips to The Same Position
 */
public class MinimumCostToMoveChipsToTheSamePosition {
    public static int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;

        for (int i = 0; i < position.length; i++) {
            if(position[i] % 2 == 1){
                ++odd;
            } else {
                ++even;
            }
        }

        return odd > even ? even : odd;
    }
    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{1,2,3})); // 1
    }
}
