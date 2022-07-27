package leetcode.easy;

/**
 * 1880. Check if Word Equals Summation of Two Words
 */
public class CheckifWordEqualsSummationofTwoWords {

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        final int VALUE = 97;
        char[] firstChars = firstWord.toCharArray();
        char[] secondChars = secondWord.toCharArray();
        char[] targetChars = targetWord.toCharArray();

        String firstString = "";
        for (int i = 0; i < firstChars.length; i++) {
            firstString += (firstChars[i] - VALUE);
        }

        String secondeString = "";
        for (int i = 0; i < secondChars.length; i++) {
            secondeString += (secondChars[i] - VALUE)+"";
        }

        String targetString = "";
        for (int i = 0; i < targetChars.length; i++) {
            targetString += (targetChars[i] - VALUE) + "";
        }

        return ((Integer.parseInt(firstString) + Integer.parseInt(secondeString)) == Integer.parseInt(targetString));
    }

    public static void main(String[] args) {
        System.out.println(isSumEqual("acb","cba","cdb"));
        System.out.println(isSumEqual("aaa","a","aab"));
        System.out.println(isSumEqual("aaa","a","aaaa"));
        System.out.println(isSumEqual("j","j","bi"));  //true
    }

}
