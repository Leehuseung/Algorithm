package leetcode.top.interview.solution;

/**
 * 45. Jump Game II
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        return 0;
    }
    public static int bestJump(int[] nums) {
        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for(int i=0; i<nums.length-1; i++) {
            current_jump_max = Math.max(current_jump_max, i+nums[i]);
            if( i == last_jump_max ) {
                step_count++;
                last_jump_max = current_jump_max;
            }
        }
        return step_count;
    }
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4})); // 2
//        System.out.println(jump(new int[]{2,3,0,1,4})); // 2
//        System.out.println(jump(new int[]{1,2,1,1,1})); // 3
//        System.out.println(jump(new int[]{1})); // 0
//        System.out.println(jump(new int[]{7,0,100,6,9,6,1,3,9,0,1,2,9,0,3})); // 2
    }
}
