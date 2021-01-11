package programmers.lv1;

public class CenterNumGet {
    public static void main(String[] args) {
        System.out.println("결과는 : "+solution("abcde"));

    }

    public static String solution(String s) {
        String answer = "";

        int size = s.length();

        int num = size/2;

        //짝수이면
        if(size%2 == 0){
            answer = s.charAt(num-1)+"" +s.charAt(num);
        //홀수이면
        } else {
            answer = s.charAt(num)+"";
        }
        return answer;
    }
}
