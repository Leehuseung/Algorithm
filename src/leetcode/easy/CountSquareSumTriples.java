package leetcode.easy;

/**
 * 1925. Count Square Sum Triples
 */
public class CountSquareSumTriples {

    public static int countTriples(int n) {
        int answer = 0;
        int k = n * n;
        for (int i = 1; i < n; i++) {
            int t = i * i;
            for (int j = 1; j < n; j++) {
                int p = j * j;
                int sum = t + p;
                if(sum > k){
                    continue;
                }
                if(Math.sqrt(sum) - (long)Math.sqrt(sum) == 0){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        countTriples(5); // 2
//        System.out.println(countTriples(10)); // 4
    }
}
