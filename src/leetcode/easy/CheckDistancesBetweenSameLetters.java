package leetcode.easy;

/**
 * 2399. Check Distances Between Same Letters
 */
public class CheckDistancesBetweenSameLetters {
    public static boolean checkDistances(String s, int[] distance) {
        char c = 'a';
        char[] chars = s.toCharArray();
        for (int i = 0; i < distance.length; i++) {
            if(!s.contains(c+"")){
                c++;
                continue;
            }
            int dist = 0;
            int k = -1;
            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == c && k == -1){
                    k = j;
                } else if(chars[j] == c && k != -1){
                    dist = j-k-1;
                }
            }

            if(distance[i] != dist){
                c++;
                return false;
            }

            c++;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println(checkDistances("bb", new int[]{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println(checkDistances("zz", new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}));
    }
}
