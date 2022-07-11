package leetcode.easy;

/**
 * 1837. Sum of Digits in Base K
 */
public class SumOfDigitsInBaseK {

    public static int sumBase(int n, int k) {
        int answer = 0;
        while(n / k > 0){
            answer +=  n % k;
            n = n/k;
        }
        answer += n;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(sumBase(34,6)); // 9
        System.out.println(sumBase(10,10)); // 1
    }
}
