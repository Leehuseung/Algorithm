package leetcode.easy;

/**
 * 2529. Maximum Count of Positive Integer and Negative Integer
 */
public class MaximumCountOfPositiveInteger {

    public static int maximumCount(int[] nums) {
        int po = 0;
        int ne = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) ne++;
            if(nums[i] > 0) po++;
        }
        return po > ne ? po : ne;
    }

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-2,-1,-1,1,2,3})); //3
        System.out.println(maximumCount(new int[]{-3,-2,-1,0,0,1,2}));  //3
        System.out.println(maximumCount(new int[]{5,20,66,1314}));  //4
    }
}
