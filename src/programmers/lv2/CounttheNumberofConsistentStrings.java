package programmers.lv2;

/**
 * LeetCode 1684. Count the Number of Consistent Strings
 */
public class CounttheNumberofConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(allowed.indexOf(c) == -1){
                    break;
                }
                if(s.length()-1 == j){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab",new String[] {"ad","bd","aaab","baa","badab"})); // 2
        System.out.println(countConsistentStrings("abc",new String[] {"a","b","c","ab","ac","bc","abc"})); // 7
        System.out.println(countConsistentStrings("cad",new String[] {"cc","acd","b","ba","bac","bad","ac","d"})); // 4
    }
}
