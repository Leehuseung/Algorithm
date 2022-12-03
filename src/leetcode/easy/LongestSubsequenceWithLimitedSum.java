package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2389. Longest Subsequence With Limited Sum
 */
public class LongestSubsequenceWithLimitedSum {

    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int t = 0;
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                t += nums[j];
                if(t > queries[i]){
                    break;
                }
                cnt++;
            }

            list.add(cnt);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

//    public static int[] answerQueries(int[] A, int[] queries) {
//        Arrays.sort(A);
//        int n = A.length, m = queries.length, res[] = new int[m];
//        for (int i = 1; i < n; ++i)
//            A[i] += A[i - 1];
//        for (int i = 0; i < m; ++i) {
//            int j = Arrays.binarySearch(A, queries[i]);
//            res[i] = Math.abs(j + 1);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(answerQueries(new int[]{4,5,2,1},new int[]{3,10,21})));
    }
}
