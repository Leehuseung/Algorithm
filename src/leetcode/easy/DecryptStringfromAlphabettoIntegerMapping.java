package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1309. Decrypt String from Alphabet to Integer Mapping
 */
public class DecryptStringfromAlphabettoIntegerMapping {

    public static String freqAlphabets(String s) {
        Map<String,String> map = new HashMap<>();
        String answer = "";

        char c = 'a';
        for (int i = 1; i <= 9; i++) {
            map.put(i+"",c+"");
            c++;
        }
        c = 'j';
        for (int i = 10; i < 27; i++) {
            map.put(i+"#",c+"");
            c++;
        }

        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '#'){
                String de = s.substring(i-2,i+1);
                i -= 2;
                answer = map.get(de)+ answer;
            } else {
                String de = s.substring(i,i+1);
                answer = map.get(de) + answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));  //jkab
        System.out.println(freqAlphabets("1326#"));     //acz
    }
}
