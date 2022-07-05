package leetcode.easy;

/**
 * LeetCode 1370. Increasing Decreasing String
 */
public class IncreasingDecreasingString {

    public static String sortString(String s) {
        int[] arr = new int[26];
        for(char ch: s.toCharArray())  arr[ch-'a']++;

        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()){
            for(int i=0; i<26; i++){
                if(arr[i] > 0){
                    sb.append((char)(i+'a'));
                    arr[i]--;
                }
            }
            for(int i=25; i>=0; i--){
                if(arr[i] > 0){
                    sb.append((char)(i+'a'));
                    arr[i]--;
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc")); //abccbaabccb a
        System.out.println(sortString("rat")); //art
        System.out.println(sortString("leetcode")); //cdelotee
    }
}