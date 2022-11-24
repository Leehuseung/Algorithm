package leetcode.easy;

/**
 * 2427. Number of Common Factors
 */
public class NumberofCommonFactors {

    public int commonFactors(int a, int b) {
        int mid = 0;
        if(a > b){
            mid = a;
        } else {
            mid = b;
        }

        int total = 0;
        for (int i = 1; i <= b; i++) {
            if(a % i == 0 && b % i == 0){
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
