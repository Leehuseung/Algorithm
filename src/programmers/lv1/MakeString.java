package programmers.lv1;

import java.util.Locale;

public class MakeString {
    public static void main(String[] args) {
        System.out.println(solution("try hello world   "));
        System.out.println(solution("t h aaaaaaaa rgag rmklgaremklh amrkherlmmkl haermhkl mkl"));
    }

    public static String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String a = arr[i].toLowerCase();

            String[] aArr = a.split("");

            arr[i] = "";
            for (int j = 0; j < aArr.length; j++) {
                //짝
                if(j % 2 == 0){
                    arr[i] += aArr[j].toUpperCase();
                    //홀
                } else {
                    arr[i] += aArr[j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
            if(arr.length-1 != i){
                answer += " ";
            }
        }

        String[] arr2 = s.split("");
        String empty = "";
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i].equals(" ")){
                empty += " ";
            } else {
                empty = "";
            }
        }
        answer += empty;

        return answer;
    }
}
