package programmers.lv2;

/**
 * Lv2. 예상 대진표
 */
public class ExpectationDraw {
    public static int solution(int n, int a, int b) {
        int answer = 1;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        while(!isMatch(arr,a,b)){
            arr = goTournament(arr,a,b);
            answer++;
        }

        return answer;
    }

    public static boolean isMatch(int[] arr,int winnerA, int winnerB){
        for (int i = 0; i < arr.length; i+=2) {
            if((arr[i] == winnerA && arr[i+1] == winnerB) || (arr[i] == winnerB && arr[i+1] == winnerA)){
                return true;
            }
        }
        return false;
    }

    public static int[] goTournament(int[] arr,int winnerA, int winnerB) {
        int[] people = new int[arr.length / 2];
        for (int i = 0; i < arr.length/2; i++) {
            int b = arr[i*2+1];
            if(b == winnerA || b == winnerB){
                people[i] = arr[i*2+1];
            } else {
                people[i] = arr[i*2];
            }
        }
        return people;
    }


    public static void main(String[] args) {
        System.out.println(solution(8,4,7)); // 3
    }
}
