package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 933. Number of Recent Calls
 *
 * 싫어요 압도적으로 높아서 패스
 */
public class NumberofRecentCalls {

    List<Integer> list;

    public NumberofRecentCalls() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int index = Collections.binarySearch(list, t - 3000); // search the index of t - 3000.
        if (index < 0) { index = ~index; } // if t - 3000 is not in list, use the index of the ceiling of t - 3000.
        return list.size() - index;
    }

    public static void main(String[] args) {

    }

}
