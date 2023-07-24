package leetcode.top.interview.solution;


/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i+1] - prices[i] > 0) {
                result += prices[i+1] - prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{5,1,7,2,1}));
    }
}
