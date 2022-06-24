package leetcode.easy;

/**
 * 1832. Check if the Sentence Is Pangram
 */
public class CheckiftheSentenceIsPangram {

    public static boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        char c = 'a';
        for (int i = 0; i < 26; i++) {
            if(sentence.indexOf(c) < 0){
                return false;
            }
            c++;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog")); // true
//        System.out.println(checkIfPangram("leetcode")); // false
        System.out.println(checkIfPangram("jwtucoucmdfwxxqnxzkaxoglszmfrcvjoiunqqausaxxaaijyqdqgvdnqcaihwilqkpivenpnekioyqujrdrovqrlxovcucjqzjsxmllfgndfprctxvxwlzjtciqxgsxfwhmuzqvlksyuztoetyjugmswfjtawwaqmwyxmvo")); // false
    }
}
