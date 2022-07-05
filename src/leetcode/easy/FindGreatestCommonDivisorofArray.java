package leetcode.easy;

/**
 * 1979. Find Greatest Common Divisor of Array
 */
public class FindGreatestCommonDivisorofArray {

    public static int findGCD(int[] nums) {
        int max = 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        return gcd(max,min);
    }

    private static int gcd(int max, int min) {
        if(min == 0){
            return max;
        } else {
            return gcd(min, max % min);
        }
    }

    public static void main(String[] args) {
        System.out.println(findGCD(new int[]{2,5,6,9,10}));  //2
        System.out.println(findGCD(new int[]{7,5,6,8,3}));  //1
        System.out.println(findGCD(new int[]{3,3}));  //3
    }
}
