package leetcode.easy;

/**
 * 2278. Percentage of Letter in String
 */
public class PercentageofLetterinString {

    public static int percentageLetter(String s, char letter) {
        int total = s.length();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == letter){
                cnt++;
            }
        }

        if(cnt == 0){
            return cnt;
        }

        return (cnt*100)/total;
    }

    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar",'o')); //33
//        System.out.println(percentageLetter("jjjj",'k')); //0
    }
}
