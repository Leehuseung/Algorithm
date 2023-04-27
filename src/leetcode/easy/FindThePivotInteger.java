package leetcode.easy;

/**
 * 2485. Find the Pivot Integer
 */
public class FindThePivotInteger {
    public static int pivotInteger(int n) {
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            int a = 0;
            for (int j = 1; j <= i; j++) {
                a += j;
            }
            int b = 0;
            for (int j = i; j <= n; j++) {
                b += j;
            }
            if(a == b){
                return i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(4));
    }
}
