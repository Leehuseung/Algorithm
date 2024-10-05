package leetcode.easy;

/**
 * 242. Valid Anagram
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] arr1 = new int[30];
        int[] arr2 = new int[30];
        char[] c = t.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int k = c[i]-'a';
            arr1[k]++;
        }

        char[] c2 = s.toCharArray();
        for (int i = 0; i < c2.length; i++ ) {
            int k = c2[i]-'a';
            arr2[k]++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagramz", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
