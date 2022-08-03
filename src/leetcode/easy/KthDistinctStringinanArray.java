package leetcode.easy;

import java.util.ArrayList;

/**
 * 2053. Kth Distinct String in an Array
 */
public class KthDistinctStringinanArray {

    public static String kthDistinct(String[] arr, int k) {
        ArrayList<String> list = new ArrayList<>();
        loop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(j == i){
                    continue;
                }
                if(arr[i].equals(arr[j])){
                    continue loop;
                }
            }
            list.add(arr[i]);
        }
        if(k > list.size()){
            return "";
        }
        return list.get(k-1);
    }

    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d","b","c","b","c","a"},2)); //a
    }
}
