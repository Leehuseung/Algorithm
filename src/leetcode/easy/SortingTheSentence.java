package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class SortingTheSentence {

    public static String sortSentence(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(o1.length()-1) > o2.charAt(o2.length()-1)){
                    return 1;
                } else if(o1.charAt(o1.length()-1) < o2.charAt(o2.length()-1)){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i].substring(0,arr[i].length()-1);
            if(i != arr.length-1){
                answer += " ";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3")); // This is a sentence
        System.out.println(sortSentence("Myself2 Me1 I4 and3")); //Me Myself and I

    }
}
