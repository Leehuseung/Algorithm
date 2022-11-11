package leetcode.easy;

import java.util.Arrays;

/**
 * 2138. Divide a String Into Groups of Size k
 */
public class DivideaStringIntoGroupsofSizek {

    public static String[] divideString(String s, int k, char fill) {
        char[] chars = s.toCharArray();
        int len = s.length()/k;
        if(s.length()%k >= 1){
            len++;
        }
        String[] arr = new String[len];
        Arrays.fill(arr,"");

        for (int i = 0; i < chars.length; i++) {
            arr[i/k] = arr[i/k] + chars[i];
        }

        while(arr[arr.length-1].length() != k){
            arr[arr.length-1] = arr[arr.length-1] + fill;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghij",3,'x')));
    }
}