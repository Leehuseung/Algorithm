package leetcode.easy;

/**
 * 2243. Calculate Digit Sum of a String
 */
public class CalculateDigitSumofaString {
    public static String digitSum(String s, int k) {
        while(s.length() > k){
            s = calculate(s,k);
        }
        return s;
    }

    private static String calculate(String answer, int k) {
        int t = 0;
        String d = "";
        while(t < answer.length()){
            int p = 0;
            for (int i = t; i < t+k; i++) {
                if(i > answer.length()-1){
                    break;
                }
                p += Integer.parseInt(answer.charAt(i)+ "");
            }
            d += p;
            t += k;
        }
        return d;
    }

    public static void main(String[] args) {
        System.out.println(digitSum("11111222223",3)); //135
        System.out.println(digitSum("1234",2)); //37
    }
}
