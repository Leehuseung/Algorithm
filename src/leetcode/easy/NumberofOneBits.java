package leetcode.easy;

/**
 * 191. Number of 1 Bits
 */
public class NumberofOneBits {

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
}
