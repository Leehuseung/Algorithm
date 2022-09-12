package programmers.lv1;

/**
 * Lv1. 성격 유형 검사하기
 */
public class MbtiTest {

    public static String solution(String[] survey, int[] choices) {
        int[] table = new int[8];
        String[] answerTable = new String[]{"R","T","C","F","J","M","A","N"};

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int n = choices[i];
            if(n < 4){
                addScore(table,s.charAt(0)+"",4-n);
            } else if(n > 4) {
                addScore(table,s.charAt(1)+"",n-4);
            }
        }

        String answer = "";
        for (int i = 0; i < table.length; i+=2) {
            if(table[i] < table[i+1]){
                answer += answerTable[i+1];
            } else {
                answer += answerTable[i];
            }
        }

        return answer;
    }

    public static void addScore(int[] table, String s, int n){
        switch (s){
            case "R" : table[0] = table[0]+n;
            break;
            case "T" : table[1] = table[1]+n;
            break;
            case "C" : table[2] = table[2]+n;
            break;
            case "F" : table[3] = table[3]+n;
            break;
            case "J" : table[4] = table[4]+n;
            break;
            case "M" : table[5] = table[5]+n;
            break;
            case "A" : table[6] = table[6]+n;
            break;
            case "N" : table[7] = table[7]+n;
            break;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5,3,2,7,5})); //TCMA
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7,1,3})); //RCJA
    }
}
