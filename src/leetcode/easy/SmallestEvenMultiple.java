package leetcode.easy;

/**
 * 2413. Smallest Even Multiple
 */
public class SmallestEvenMultiple {
    public static int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
