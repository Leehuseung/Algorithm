package leetcode.easy;

/**
 * 1732. Find the Highest Altitude
 */
public class FindtheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7})); // 1
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2})); // 0
    }
}
