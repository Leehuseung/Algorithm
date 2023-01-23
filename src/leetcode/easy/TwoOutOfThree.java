package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2032. Two Out of Three
 */
public class TwoOutOfThree {
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        processArr(map,nums1,1,list);
        processArr(map,nums2,2,list);
        processArr(map,nums3,3,list);
        return list;
    }

    private static void processArr(HashMap<Integer, Integer> map, int[] nums, int i, List<Integer> list) {
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            if(map.containsKey(num)){
                if(map.get(num) != i && !list.contains(num)){
                    list.add(num);
                }
            } else {
                map.put(num,i);
            }
        }
    }

    public static void main(String[] args) {
        twoOutOfThree(
                new int[]{1,1,3,2},
                new int[]{2,3},
                new int[]{3}
        );

//        twoOutOfThree(
//                new int[]{3,1},
//                new int[]{2,3},
//                new int[]{1,2}
//        );

//        twoOutOfThree(
//                new int[]{1,2,2},
//                new int[]{4,3,3},
//                new int[]{5}
//        );
    }
}
