package leetcode.easy;

import java.util.Arrays;

/**
 * 1475. Final Prices With a Special Discount in a Shop
 */
public class FinalPricesWithaSpecialDiscountinaShop {
    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i+1; j < prices.length; j++) {
                min = Math.min(min,prices[j]);
                if(prices[i] >= min){
                    break;
                }
            }
            if(min <= prices[i]){
                prices[i] = prices[i] - min;
            }
        }
        return prices;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8,4,6,2,3})));  // 4,2,4,2,3
        System.out.println(Arrays.toString(finalPrices(new int[]{1,2,3,4,5})));  // 1,2,3,4,5
        System.out.println(Arrays.toString(finalPrices(new int[]{10,1,1,6})));  // 9,0,1,6
    }
}
