package programmers.lv2;

/**
 * Lv2. 피로도
 */
public class Fatique {
    static int[][] arr;
    static boolean[] bools;
    static int num;
    static int answer;
    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        arr = dungeons;
        num = k;
        bools = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            backtracking(i,i+"");
        }
        return answer;
    }

    private static void backtracking(int i, String s) {
        bools[i] = true;
        if(s.length() == arr.length){
            int user = num;
            int max = 0;
            for (int j = 0; j < s.length(); j++) {
                int index = Integer.parseInt(s.charAt(j) + "");
                int[] dungeon = arr[index];
                int min = dungeon[0];
                int fatigue = dungeon[1];
                if(min > user){
                    break;
                } else {
                    user -= fatigue;
                    max++;
                }
            }
            answer = Math.max(answer,max);
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if(!bools[j]){
                backtracking(j,s+j);
                bools[j]=false;
            }
        }
        bools[i] = false;
    }

    public static void main(String[] args) {
        System.out.println(solution(80,new int [][]{{80,20},{50,40},{30,10}})); // 3
    }
}
