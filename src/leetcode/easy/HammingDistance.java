package leetcode.easy;

/**
 * 461. Hamming Distance
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4)); // 2
        System.out.println(hammingDistance(3,1)); // 1
        System.out.println(hammingDistance(93,73)); // 1
        System.out.println(hammingDistance(0,10)); // 1
    }
}
