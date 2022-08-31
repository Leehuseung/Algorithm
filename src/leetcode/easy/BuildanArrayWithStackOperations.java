package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. Build an Array With Stack Operations
 */
public class BuildanArrayWithStackOperations {

    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j=0;
        for (int i = 1; i <= n && j<target.length; i++) {
            result.add("Push");
            if(target[j]==i) {
                j++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{1,3},3));
        System.out.println(buildArray(new int[]{1,3},3));
        System.out.println(buildArray(new int[]{1,3},3));
    }
}
