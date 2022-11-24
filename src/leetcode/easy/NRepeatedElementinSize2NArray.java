package leetcode.easy;

/**
 * 961. N-Repeated Element in Size 2N Array
 */
public class NRepeatedElementinSize2NArray {
    public static int repeatedNTimes(int[] nums) {
        int answer = 0;
        int len = nums.length/2;
        int[] arr = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = arr[nums[i]] + 1;
            if(arr[nums[i]] == len){
                return nums[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1,2,3,3}));//3
        System.out.println(repeatedNTimes(new int[]{2,1,2,5,3,2}));//2
        System.out.println(repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));//5
    }
}
