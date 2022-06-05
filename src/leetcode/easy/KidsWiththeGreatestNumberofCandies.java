package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Easy 1431. Kids With the Greatest Number of Candies
 */
public class KidsWiththeGreatestNumberofCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> list = new ArrayList<>();

        int greatestCandyNum = 0;

        for (int i = 0; i < candies.length; i++) {
            if(greatestCandyNum < candies[i]){
                greatestCandyNum = candies[i];
            }
            candies[i] += extraCandies;
        }

        for (int i = 0; i < candies.length; i++) {
            if(candies[i] >= greatestCandyNum){
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
