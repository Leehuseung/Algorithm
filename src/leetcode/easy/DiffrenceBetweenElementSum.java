package leetcode.easy;

/**
 * 2535. Difference Between Element Sum and Digit Sum of an Array
 */
public class DiffrenceBetweenElementSum {

    public static int differenceOfSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int k = nums[i];
            while(k > 0){
                sum -= (k % 10);
                k = k /10;
            }
        }
        return Math.abs(sum);
    }

    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[]{1,15,6,3})); //9
        System.out.println(differenceOfSum(new int[]{1,2,3,4}));  //0
    }
}
