package programmers.lv1;

public class Colache {
    public static void main(String[] args) {
        System.out.println(solution(16));
    }
    public static int solution(int num) {
        int answer = 0;
        long a  = (long)num;
        if(a == 1) {
            return 0;
        }

        while(true){
            if(answer == 500){
                return -1;
            }
            //짝수이면
            if(a%2 == 0){
                a = a/2;
            //홀수이면
            } else {
                a = a * 3 + 1;
            }

            answer++;

            if(a == 1){
                return answer;
            }
        }
    }
}
