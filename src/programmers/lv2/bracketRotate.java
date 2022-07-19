package programmers.lv2;

/**
 * Lv2. 괄호 회전하기
 */
public class bracketRotate {
    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if(isComplete(s)){
                answer++;
            }
            s = s.substring(1) + s.substring(0,1);
        }
        return answer;
    }

    private static boolean isComplete(String s) {
        char[] arr = s.toCharArray();
        while(true){
            boolean change = false;
            for (int i = 0; i < arr.length-1; i++) {
                if(((arr[i] == '(' && arr[i+1] == ')') || (arr[i] == '{' && arr[i+1] == '}') || (arr[i] == '[' && arr[i+1] == ']'))){
                    if(i == 0){
                        s = s.substring(i+2);
                    } else {
                        s =  s.substring(0,i) + s.substring(i+2);
                    }
                    arr = s.toCharArray();
                    change = true;
                    break;
                }
            }
            if(!change) return false;
            if(s.length() == 0) return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));  //3
        System.out.println(solution("}]()[{"));  //2
        System.out.println(solution("({[]})}{"));  //1
        System.out.println(solution("(){[()]}]["));  //1
        System.out.println(solution("[)(]"));  //0
        System.out.println(solution("}}}"));  //0
        System.out.println(solution("[(])"));  //0
    }
}
