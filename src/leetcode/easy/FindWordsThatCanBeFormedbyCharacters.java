package leetcode.easy;

/**
 * 1160. Find Words That Can Be Formed by Characters
 */
public class FindWordsThatCanBeFormedbyCharacters {
    public static int countCharacters(String[] words, String chars) {
        int[] a = new int[26];
        int l = 0;
        for (int i = 0; i < chars.length(); i++) {
            a[chars.charAt(i) - 'a']++;
        }
        int[] b = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < a.length; k++) {
                b[k] = a[k];
            }
            boolean isHas = true;
            for (int j = 0; j < words[i].length(); j++) {
                b[words[i].charAt(j) - 'a']--;
                if (b[words[i].charAt(j) - 'a'] < 0) {
                    isHas = false;
                    break;
                }
            }
            if (isHas) {
                l += words[i].length();
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters(new String[]{"hello","world","leetcode"},"wellldonehoneyr"));
    }

}
