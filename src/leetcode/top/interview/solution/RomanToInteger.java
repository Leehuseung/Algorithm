package leetcode.top.interview.solution;

public class RomanToInteger {

    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            char ss = arr[i];
            switch (ss) {
                case 'I':
                    if(i < arr.length-1 && arr[i+1] == 'V') {
                        i++;
                        result += 4;
                    } else if(i < arr.length-1 && arr[i+1] == 'X'){
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if(i < arr.length-1 && arr[i+1] == 'L') {
                        i++;
                        result += 40;
                    } else if(i < arr.length-1 && arr[i+1] == 'C'){
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if(i < arr.length-1 && arr[i+1] == 'D') {
                        i++;
                        result += 400;
                    } else if(i < arr.length-1 && arr[i+1] == 'M'){
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }

    public static int bestRomanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(romanToInt("III")); // 3
//        System.out.println(romanToInt("LVIII")); // 58
//        System.out.println(bestRomanToInt("MCMXCIV")); // 1994
//        System.out.println(bestRomanToInt("IVIX")); // 1994
        System.out.println(bestRomanToInt("IM")); // 1994
    }
}
