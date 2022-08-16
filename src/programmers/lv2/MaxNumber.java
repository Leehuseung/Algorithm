package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Lv2. 가장 큰 수
 */
public class MaxNumber {

    public static String solution(int[] numbers) {
        String answer = "";

        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = numbers[i] + "";
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;



                return -a.compareTo(b);
            }
        });

        for (int i = 0; i < strings.length; i++) {
            if(!answer.equals("0")){
                answer += strings[i];
            }

        }
        return answer;
    }



    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{412,41}));
        System.out.println(solution(new int[]{303,30}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution(new int[]{10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(solution(new int[]{104,1}));
        System.out.println(solution(new int[]{0,0,0,1000}));
        System.out.println(solution(new int[]{0,0,1000,0}));
        System.out.println(solution(new int[]{1000,0,0,0}));
        System.out.println(solution(new int[]{0,0,0,0}));
        System.out.println(solution(new int[]{1}));
        System.out.println(solution(new int[]{12,1213}));
        System.out.println(solution(new int[]{2,22}));
        System.out.println(solution(new int[]{12,121}));
        System.out.println(solution(new int[]{40,403}));
        System.out.println(solution(new int[]{2,22,223}));
        System.out.println(solution(new int[]{998,9,999}));
        System.out.println(solution(new int[]{1,112}));
        System.out.println(solution(new int[]{2357,235785}));
    }
}
