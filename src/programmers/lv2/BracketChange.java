package programmers.lv2;

/**
 * Lv2. 괄호 변환
 */
public class BracketChange {
    public static String solution(String p) {
        return extracted(p);
    }

    private static String extracted(String p) {
        while(!isRight(p)){

            String[] devide = getDevideString(p);
            String u = devide[0];
            String v = devide[1];

            if(isRight(u)) {
                return u + extracted(v);
            }
            p = "";

            // 빈 문자열에 "(" 를 붙입니다.
            p += "(";

            //재귀한 결과를 붙힙니다.
            p += extracted(v);

            // 빈 문자열에 ")" 를 붙입니다.
            p += ")";

            // u의 첫번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙힙니다.
            u = u.substring(1,u.length()-1);
            u = u.replaceAll("\\(","1").replaceAll("\\)","2").replaceAll("1","\\)").replaceAll("2","\\(");
            p += u;
            return p;
        }
        return p;
    }

    private static String[] getDevideString(String p) {
        int i = 0;
        for (int j = 0; j < p.length(); j++) {
            if(p.charAt(j) == '('){
                i++;
            } else if(p.charAt(j) == ')'){
                i--;
            }
            if(j != 0 && i == 0){
                return new String[]{p.substring(0,j+1),p.substring(j+1)};
            }
        }
        return null;
    }


    public static boolean isRight(String s) {
        int middle = 0;
        if(s.length() == 0){
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                middle++;
            } else if(s.charAt(i) == ')'){
                middle--;
            }
            if(middle < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));//    (()())()
        System.out.println(solution(")("));//          ()
        System.out.println(solution("()))((()"));//    ()(())()
    }
}