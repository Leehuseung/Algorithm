package programmers.lv2;

/**
 * Lv2. N진수 게임
 */
public class NGame {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        int turn = 0;
        int realturn = 0;

        while(true){
            String number = Integer.toString(turn,n);
            for (int i = 0; i < number.length(); i++) {

                if(answer.length() == t){
                    return answer.toUpperCase();
                }
                if(realturn % m == p-1){
                    answer += number.charAt(i) + "";
                }
                realturn++;
            }
            turn++;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(2,4,2,1));   //0111
        System.out.println(solution(16,16,2,1));   //02468ACE11111111
        System.out.println(solution(16,16,2,2));   //13579BDF01234567

    }
}
