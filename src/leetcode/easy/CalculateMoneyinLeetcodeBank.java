package leetcode.easy;

/**
 * 1716. Calculate Money in Leetcode Bank
 */
public class CalculateMoneyinLeetcodeBank {

    public static int totalMoney(int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += i / 7;
            total += i % 7 + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(4));
    }
}
