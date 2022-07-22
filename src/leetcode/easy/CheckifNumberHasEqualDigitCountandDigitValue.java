package leetcode.easy;

/**
 * 2283. Check if Number Has Equal Digit Count and Digit Value
 */
public class CheckifNumberHasEqualDigitCountandDigitValue {

    public static boolean digitCount(String num) {
        int[] table = new int[10];
        for (int i = 0; i < num.length(); i++) {
            Integer k = Integer.parseInt(num.charAt(i)+"");
            table[k] = table[k] + 1;
        }

        for (int i = 0; i < num.length(); i++) {
            if(table[i] != Integer.parseInt(num.charAt(i)+"")){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(digitCount("1210")); // true
        System.out.println(digitCount("030"));  // false
    }
}
