package leetcode.easy;

/**
 * 1863. Sum of All Subset XOR Totals
 */
public class SumofAllSubsetXORTotals {
    static int answer;
    static boolean flag;
    public static int subsetXORSum(int[] nums) {
        answer = 0;
        flag = false;
        recur(nums,0,0, 0);
        return answer;
    }

    private static void recur(int[] nums,int depth,int start, int xor) {
        ++depth;
        if(nums.length == depth){
            if(flag == false){
                answer += xor ^ nums[nums.length-1];
                flag = true;
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            recur(nums,depth,i+1, xor ^ nums[i]);
            answer += xor ^ nums[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1,3})); // 6
        System.out.println(subsetXORSum(new int[]{5,1,6})); // 28
        System.out.println(subsetXORSum(new int[]{3,4,5,6,7,8})); // 480
    }
}
