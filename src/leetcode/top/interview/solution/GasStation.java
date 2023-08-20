package leetcode.top.interview.solution;

/**
 * 134. Gas Station
 */
public class GasStation {

    public static int myCanCompleteCircuit(int[] gas, int[] cost) {

        return 0;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sGas = 0, sCost = 0, res = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            sGas += gas[i];
            sCost += cost[i];
        }
        if (sGas < sCost) return -1;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(
                new int[]{1,2,3,4,5},
                new int[]{3,4,5,1,2}
        )); // 3
    }
}
