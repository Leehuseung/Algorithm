package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. Distribute Candies
 */
public class DistributeCandies {

    public static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) set.add(candyType[i]);
        int answer = candyType.length/2;
        if(answer > set.size()) return set.size();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{}));
    }
}
