package leetcode.easy;

/**
 * 1704. Determine if String Halves Are Alike
 */
public class DetermineifStringHalvesAreAlike {

    public static boolean halvesAreAlike(String s) {
        s = s.toLowerCase();

        String vowel = "aeiou";
        int answer = 0;

        char[] arr = s.toCharArray();

        for (int i = 0; i < s.toCharArray().length; i++) {
            if(s.length() / 2 > i && vowel.indexOf(arr[i]) > -1){
                answer++;
            } else if(s.length() / 2 <= i && vowel.indexOf(arr[i]) > -1){
                answer--;
            }
        }

        return answer == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book")); //true
        System.out.println(halvesAreAlike("textbook")); //false
    }
}
