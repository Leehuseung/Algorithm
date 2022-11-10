package leetcode.easy;

/**
 * 1779. Find Nearest Point That Has the Same X or Y Coordinate
 */
public class FindNearestPoint {

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < points.length; i++) {
            int pointX = points[i][0];
            int pointY = points[i][1];

            if(x == pointX || y == pointY){
                int len = Math.abs(x - pointX) + Math.abs(y - pointY);
                if(len < min){
                    min = len;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
//        System.out.println(nearestValidPoint(3,4,new int[][]{{1,2},{3,1},{2,4},{2,3},{4,4}}));
//        System.out.println(nearestValidPoint(3,4,new int[][]{{3,4}}));
//        System.out.println(nearestValidPoint(3,4,new int[][]{{1,2},{3,1},{2,4},{2,3},{4,4}}));
//        System.out.println(nearestValidPoint(1,1,new int[][]{{1,1},{1,1}})); // 1
//        System.out.println(nearestValidPoint(1,1,new int[][]{{1,2},{3,3},{3,3}})); // 1
    }
}
