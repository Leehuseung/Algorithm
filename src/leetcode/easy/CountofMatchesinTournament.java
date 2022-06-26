package leetcode.easy;

/**
 * 1688. Count of Matches in Tournament
 */
public class CountofMatchesinTournament {
    public static int numberOfMatches(int n) {
        int answer = 0;
        while(n != 1){
            //짝수이면
            if(n % 2 == 0) {
                n /= 2;
                answer += n;
            } else {
                n = (n/2) + 1;
                answer += n-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));  // 6
        System.out.println(numberOfMatches(14)); // 13
    }
}
