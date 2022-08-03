package programmers.lv2;

/**
 * Lv2. JadenCase 문자열 만들기
 *
 * 22.06.20 -> 22.06.21
 */
public class JadenCase {
    public static String solution(String s) {
        char[] arr = s.toCharArray();

        if(arr[0] >= 'a' && arr[0] <= 'z'){
            arr[0] = (char) (arr[0] - 32);
        }

        for (int i = 0; i < arr.length; i++) {
            if(i != 0 && arr[i-1] == ' ' && arr[i] >= 'a' && arr[i] <= 'z'){
                arr[i] = (char) (arr[i] - 32);
            } else if(i != 0 && arr[i-1] != ' ' && arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char) (arr[i] + 32);
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me")); //3people Unfollowed Me
        System.out.println(solution("for the last week"	)); //For The Last Week
        System.out.println(solution("   adgagd 3eagdag ")); //  Adgagd 3eagdag
        System.out.println(solution("a a a a a a a a a a ")); //  Adgagd 3eagdag
        System.out.println(solution("a   a   a   ")); //  Adgagd 3eagdag
        System.out.println(solution(" A  Sdf Fft ")); // A  sdf fFt
    }
}
