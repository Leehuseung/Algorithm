package leetcode.easy;

/**
 * LeetCode Easy 1470. Shuffle the Array
 */
public class ShuffleTheArray {

    public static int[] shuffle(int[] nums, int n) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length/2; i ++) {
            answer[i * 2] = nums[i];
        }

        for (int i = 0; i < nums.length/2; i++) {
            answer[(i * 2)+1] = nums[i+n];
        }
        return answer;
    }

    public static void main(String[] args) {
        shuffle(new int[]{2,5,1,3,4,7},3);
    }
}
