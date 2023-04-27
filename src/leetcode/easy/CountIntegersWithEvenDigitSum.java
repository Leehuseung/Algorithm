package leetcode.easy;

/**
 * 2180. Count Integers With Even Digit Sum
 */
public class CountIntegersWithEvenDigitSum {
    public static int countEven(int num) {
        int ans=0;
        for(int i=2;i<=num;i++){
            if(isEven(i)) ans++;
        }
        return ans;
    }

    public static boolean isEven(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n = n/10;
        }
        return sum % 2 == 0;
    }

    public static void main(String[] args) {
        countEven(4);
    }
}
