package leetcode.easy;

import java.util.Arrays;

/**
 * 1710. Maximum Units on a Truck
 */
public class MaximumUnitsonaTruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int answer = 0;
        Arrays.sort(boxTypes, (o1, o2) -> {
            if(o1[1] - o2[1] > 0){
                return -1;
            } else if(o1[1] - o2[1] < 0){
                return 1;
            }
            return 0;
        });

        for (int i = 0; i < boxTypes.length; i++) {
            for (int j = 0; j < boxTypes[i][0]; j++) {
                if(truckSize >= boxTypes[i][0]){
                   truckSize -= boxTypes[i][0];
                   answer += (boxTypes[i][0] * boxTypes[i][1]);
                   break;
                } else if (truckSize != 0 && truckSize < boxTypes[i][0]){
                    answer += (truckSize * boxTypes[i][1]);
                    truckSize = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10));
    }
}
