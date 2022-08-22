package programmers.lv2;

/**
 * Lv2. N-Queen
 *
 * 22.08.09
 *
 * 교재 대각선 행렬 아이디를 보고 풀었음.
 * 코드를 많이 참고하지는 않았지만 대각행렬의 규칙성 구하는 방법은 책을보고 풀고나서
 * 내방식대로 찾아봐서 풀이까지는 완료했음.
 * + row,col의 차를 이용해 같은 대각선에 존재하는지 여부를 알 수 있다.
 *
 * 22.08.12
 */
public class NQueen {

    static boolean[] visited;
    static int[] pick; //뽑은 위치를 저장. 0번인덱스는 첫 번째 줄에서 퀸의 위치를 의미한다.
    static int count;

    public static int solution(int n) {
        visited = new boolean[n];
        pick = new int[n];
        count = 0;

        permutation(n, 0);
        return count;
    }

    public static void permutation(int n, int idx) {
        if(n == idx) {
            count++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                pick[idx] = i;
                if(check(idx)) permutation(n, idx + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean check(int idx) {
        for(int i = 0; i < idx; i++) {
            if(pick[i] == pick[idx]) return false; //같은 행에 퀸이 존재하면 false
            if(Math.abs(idx - i) == Math.abs(pick[idx] - pick[i])) return false; //대각선에 퀸이 존재한다면 false
        }
        return true;
    }

/*  static int answer = 0;
    static boolean[] booleans;
    static boolean[] left;
    static boolean[] right;
    public static int solution2(int n) {
        booleans = new boolean[n];
        left = new boolean[n*2];
        right = new boolean[n*2];

        for (int i = 0; i < n; i++) {
            recursive(i,1,i+"");
        }

        return answer;
    }

    private static void recursive(int n,int depth,String s) {

        int i1 = depth - n + (booleans.length-1);
        int i2 = (booleans.length*2-1) - depth - n;
        if(booleans[n] || left[i1] || right[i2]){
            return;
        }

        if(depth == booleans.length){
            answer++;
            return;
        }

        booleans[n] = true;
        left[i1] = true;
        right[i2] = true;


        for (int i = 0; i < booleans.length; i++) {
            recursive(i,depth+1, s + i);
        }

        booleans[n] = false;
        left[i1] = false;
        right[i2] = false;
    }
*/

    public static void main(String[] args) {
        System.out.println(solution(4)); // 92
    }
}
