package leetcode.easy;

/**
 * 1486. XOR Operation in an Array
 */
public class XOROperationInAnArray {
    public static int xorOperation(int n, int start) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = (start + (i*2)) ^ answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5,0)); // 8
        System.out.println(xorOperation(4,3)); // 8
    }
}
