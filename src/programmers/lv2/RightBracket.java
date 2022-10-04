package programmers.lv2;

/**
 * Lv2. 올바른 괄호
 */
public class RightBracket {

    public static boolean solution(String s) {
        char[] arr = s.toCharArray();
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            index += (arr[i] == '(') ? 1 : -1;
            if(index < 0){
                return false;
            }
        }

        return (index != 0) ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()")); // true
        System.out.println(solution("(())()")); // true
        System.out.println(solution(")()(")); // false
        System.out.println(solution("(()(")); // false

    }
}
