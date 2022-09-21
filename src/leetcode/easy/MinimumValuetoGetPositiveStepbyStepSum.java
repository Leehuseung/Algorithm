package leetcode.easy;

/**
 * 1413. Minimum Value to Get Positive Step by Step Sum
 */
public class MinimumValuetoGetPositiveStepbyStepSum {

    public static int minStartValue(int[] nums) {
        int sum = 0;
        int answer = 0;
        for (int num : nums) {
            sum += num;
            if(sum <= 0){
                answer += Math.abs(sum)+1;
                sum = 1;
            }
        }
        return answer == 0 ? 1 : answer;
    }

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3,2,-3,4,2})); // 5
        System.out.println(minStartValue(new int[]{1,2})); // 1
        System.out.println(minStartValue(new int[]{1,-2,-3})); // 5

    }
}
