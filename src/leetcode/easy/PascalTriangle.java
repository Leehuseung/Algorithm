package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 */
public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> el = new ArrayList<>();
        el.add(1);
        list.add(el);
        if(numRows == 1){
            return list;
        }

        for (int i = 2; i <= numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(j == i-1 || j == 0){
                    l.add(1);
                    continue;
                }
                l.add(list.get(i-2).get(j-1) + list.get(i-2).get(j));
            }
            list.add(l);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
