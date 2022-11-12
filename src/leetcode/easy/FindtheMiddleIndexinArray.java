package leetcode.easy;

/**
 * 1991. Find the Middle Index in Array
 */
public class FindtheMiddleIndexinArray {
    public static int findMiddleIndex(int[] nums) {
        int answer = 0;
        while(answer < nums.length){
            int leftSum = 0;
            int rightSum = 0;

            if(answer > 0){
                for (int i = 0; i < answer; i++) {
                    leftSum += nums[i];
                }
            }

            if(answer < nums.length-1){
                for (int i = answer+1; i < nums.length; i++) {
                    rightSum += nums[i];
                }
            }

            if(leftSum == rightSum){
                return answer;
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2,3,-1,8,4}));
        System.out.println(findMiddleIndex(new int[]{1,-1,4}));
        System.out.println(findMiddleIndex(new int[]{2,5})); //-1
    }
}