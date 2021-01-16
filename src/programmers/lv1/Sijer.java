package programmers.lv1;

import java.util.Arrays;

public class Sijer {
    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }
    public static String solution(String s, int n) {
        String answer = "";

        char[] arr = s.toCharArray();

        for(int i = 0 ;i < arr.length; i++){
            int num = (int)arr[i];
            int a = num+n;
            //대문자이면서 더한값이 넘으면 뺴준다
            if(num > 96 && num < 123 && a > 122){
                a = a - 26;
            //소문자이면서 더한값이 122를 넘으면 빼준다
            }else if(num > 64 && num < 91 && a > 90){
                a = a - 26;
            }else if(num == 32){
                answer += arr[i];
                continue;
            }
            answer += arr[i];
            arr[i] = (char)a;
        }
        return answer;
    }
}

//a = 97
//z = 122
//A = 65
//Z = 90
//공백 = 32