package leetcode.easy;

/**
 * 2078. Two Furthest Houses With Different Colors
 */
public class TwoFurthestHousesWithDifferentColors {
    public static int maxDistance(int[] colors) {
        int answer = colors.length-1;
        while(answer > 0){
            for (int i = 0; i < colors.length; i++) {
                int start = i;
                if(i + answer <= colors.length-1){
                    int end = i + answer;
                    if(colors[start] != colors[end]){
                        return answer;
                    }
                } else {
                    break;
                }
            }
            answer--;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1,1,1,6,1,1,1}));
        System.out.println(maxDistance(new int[]{1,8,3,8,3}));
        System.out.println(maxDistance(new int[]{100,0}));
        System.out.println(maxDistance(new int[]{9,9,9,18,9,9,9,9,9,18}));
    }
}
