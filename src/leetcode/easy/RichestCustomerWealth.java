package leetcode.easy;

/**
 * LeetCode Easy 1672. Richest Customer Wealth
 */
public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int i = 0; i < accounts.length; i++) {
            int num = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                num += accounts[i][j];
            }

            if(num > max){
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
        System.out.println(maximumWealth(new int[][]{{1,5},{7,3},{3,5}}));
    }
}
