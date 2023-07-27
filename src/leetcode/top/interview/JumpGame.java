package leetcode.top.interview;

/**
 * 55. Jump Game
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable >= nums.length-1) return true;
        }
        return true;
    }
    public static boolean canJumpMy(int[] nums) {
        int select = nums[0];
        for (int i = 1; i < nums.length; i++) {
            select--;
            if(select < 0) return false;
            if(select < nums[i]) select = nums[i];
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4})); //true
//        System.out.println(canJump(new int[]{3,2,1,0,4})); //false
//        System.out.println(canJump(new int[]{0,1})); //true
    }
}
