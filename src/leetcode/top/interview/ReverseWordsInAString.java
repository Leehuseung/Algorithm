package leetcode.top.interview;

/**
 * 151. Reverse Words in a String
 */
public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int start = s.length()-1;
        int end = s.length()-1;
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) == ' '){
                start = i + 1;
                for (int j = start; j <= end; j++) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                end = start-2;
                while(end >= 0 && s.charAt(end) == ' '){
                    end--;
                    i--;
                }
            }

            if(i == 0){
                for (int j = 0; j <= end; j++) {
                    sb.append(s.charAt(j));
                }
                break;
            }
            start--;
        }
        return sb.toString();
    }
    public static String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split(" +");
        for (int i = strs.length - 1; i >= 0 ; i--) {
            sb.append(strs[i]);
            if(i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String bestReverseWords(String s) {
        s = s.trim();
        // Reverse the entire string
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();

        int start = 0; // Start index of the current word
        int end = 0;   // End index of the current word
        int i = 0;     // Current index
        int n = s.length(); // Length of the string

        sb = new StringBuilder(); // Create a new StringBuilder to store the result

        while (i < n) {
            // Skip leading spaces
            while (i < n && s.charAt(i) == ' ')
                i++;

            // Find the end of the current word
            start = i;
            while (i < n && s.charAt(i) != ' ')
                i++;

            if (start < i) {
                // Reverse the current word
                StringBuilder reversedWord = new StringBuilder(s.substring(start, i));
                reversedWord.reverse();

                // Add the reversed word to the result StringBuilder
                sb.append(reversedWord);

                // Add a space after the reversed word
                sb.append(' ');
            }
        }

        // Remove extra space at the end if present
        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(bestReverseWords("  the sky is blue  ")); // blue is sky the
//        System.out.println(reverseWords("  hello world  ")); // world hello
//        System.out.println(reverseWords("a good   example")); // example good a
    }
}
