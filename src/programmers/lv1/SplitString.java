package programmers.lv1;

/**
 * Lv1. 문자열 나누기
 */
public class SplitString {

    public static int solution(String s) {
        int answer = 0;
        String[] ss = s.split("");
        int a = 1;
        int b = 0;
        String first = ss[0];
        if(s.length() == 1) return 1;
        for (int i = 1; i < ss.length; i++) {
            if(first.equals(ss[i])) {
                a++;
            } else {
                b++;
            }
            if(a == b) {
                answer++;
                if (i == ss.length-1) {
                    break;
                } else {
                    first = ss[i+1];
                }
            } else if (a != b && i == ss.length-1) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana")); //3
        System.out.println(solution("abracadabra")); //6
        System.out.println(solution("aaabbaccccabba")); //3
        System.out.println(solution("a")); //1
    }
}
