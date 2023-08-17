package leetcode.top.interview.solution;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 *
 * 풀었지만 best 풀이 복습 필요.
 */
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        return new int[n];
    }

    public static int[] bestProductExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

    public static int[] oneProductExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }

    public int[] bruteForceProductExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for(int i = 0; i < n; i++) {
            int pro = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0,0})));

    }
    public static int[] myProductExceptSelf(int[] nums) {
        int i = 1;
        int zeroCnt = 0;
        for (int num : nums) {
            i *= num;
        }

        if(i == 0){
            i = 1;
            int k = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == 0){
                    k = j;
                    zeroCnt++;
                } else {
                    i *= nums[j];
                    nums[j] = 0;
                }
            }
            nums[k] = zeroCnt > 1 ? 0 : i;
        } else {
            for (int j = 0; j < nums.length; j++) {
                nums[j] = i / nums[j];
            }
        }

        return nums;
    }
}
