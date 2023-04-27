package leetcode.easy;

/**
 * 2520. Count the Digits That Divide a Number
 */
public class CountTheDigitsThatDivideaNumber {
    public static int countDigits(int num) {
        int n = num;
        int cnt = 0;
        while(n != 0){
            int t = n % 10;
            n = n / 10;
            if(num % t == 0) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(countDigits(7));  //1
        System.out.println(countDigits(121));  //2
        System.out.println(countDigits(1248));  //4
    }
}
