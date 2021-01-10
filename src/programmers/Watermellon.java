package programmers;

public class Watermellon {

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(1));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }

    public static String solution(int n) {
        String answer = "";
        for(int i = 0 ; i < n; i++) {
            answer += (i % 2 == 0 ?  "수" : "박");
        }
        return answer;
    }

}
