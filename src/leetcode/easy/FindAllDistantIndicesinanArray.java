package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2200. Find All K-Distant Indices in an Array
 */
public class FindAllDistantIndicesinanArray {

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> keyList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == key){
                keyList.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < keyList.size(); j++) {
                int ii = Math.abs(i-keyList.get(j));
                if(ii <= k){
                    list.add(i);
                    break;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        findKDistantIndices(new int[]{3,4,9,1,3,9,5},9,1);
    }
}
