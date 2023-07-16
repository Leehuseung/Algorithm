package leetcode.top.interview.solution;

/**
 * 121. Best Time to Buy and Sell Stock (easy)
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int result = 0;
        return result;
    }

    /*
     * Best
     */
    public static int bestMaxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for (int price : prices) {
            if (price < lsf) {
                lsf = price;
            }
            pist = price - lsf;
            if (op < pist) {
                op = pist;
            }
            System.out.println(op);
        }
        return op;
    }

    // O(n^2) Fail
    public static int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                result = Math.max(prices[j] - prices[i], result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{7}));
    }
}
