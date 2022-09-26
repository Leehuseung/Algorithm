package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2363. Merge Similar Items
 */
public class MergeSimilarItems {
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> list = new ArrayList<>();

        int[] arr = new int[1001];

        for (int i = 0; i < items1.length; i++) {
            arr[items1[i][0]] = arr[items1[i][0]] + items1[i][1];
        }

        for (int i = 0; i < items2.length; i++) {
            arr[items2[i][0]] = arr[items2[i][0]] + items2[i][1];
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                List<Integer> innerList = new ArrayList<>();
                innerList.add(i);
                innerList.add(arr[i]);
                list.add(innerList);
            }
        }

        return list;
    }
    public static void main(String[] args) {
        mergeSimilarItems(new int[][]{{1,1},{4,5},{3,8}},new int [][]{{3,1},{1,5}});
    }
}
