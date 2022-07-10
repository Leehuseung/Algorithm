package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 728. Self Dividing Numbers
 */
public class SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(isSelfDividing(i)){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isSelfDividing(int i) {
        String k = i + "";
        for (int j = 0; j < k.length(); j++) {
            int self = Integer.parseInt(k.charAt(j)+"");
            if(self == 0 || i % self != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }
}
