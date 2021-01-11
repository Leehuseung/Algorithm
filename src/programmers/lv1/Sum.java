package programmers.lv1;

public class Sum {
    public static void main(String[] args) {

    }
    public static int solution(int n) {
        int answer = 0;

        String num = n+"";

        String[] a = num.split("");

        for(int i = 0 ; i < a.length; i++){
            answer += Integer.parseInt(a[i]);
        }


        return answer;
    }
}
