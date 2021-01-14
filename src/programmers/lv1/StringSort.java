package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StringSort {
    public static void main(String[] args) {
//        String[] arr = {"sun","bed","car"};
        String[] arr = {"abce","abcd","cdx"};
        System.out.println(solution(arr,1));
    }

    public static String[] solution(String[] strings, int n) {
        String[] answer = {};

        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));

        Comparator<String> comparator = new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                char[] a = o1.toCharArray();
                char[] b = o2.toCharArray();

                int num = a[n] - b[n];
                if(num == 0){
                    return o1.compareTo(o2);
                } else {
                    return num;
                }
            }
        };

        Collections.sort(list,comparator);
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }

        return answer;
    }
}
