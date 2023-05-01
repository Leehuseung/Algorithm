package programmers.lv1;

/**
 * Lv1. 크기가 작은 부분문자열
 */
public class SmallSubstring {
    public static int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            long k = Long.parseLong(t.substring(i,i+p.length()));
            long x = Long.parseLong(p);
            if(k <= x) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("3141592","271"));
        System.out.println(solution("500220839878","7"));
    }
}
