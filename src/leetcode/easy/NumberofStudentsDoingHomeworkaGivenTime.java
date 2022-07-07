package leetcode.easy;

/**
 * 1450. Number of Students Doing Homework at a Given Time
 */

public class NumberofStudentsDoingHomeworkaGivenTime {

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int answer = 0;
        for (int i = 0; i < startTime.length; i++) {
            if((startTime[i] <= queryTime) && (queryTime <= endTime[i])){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(busyStudent(new int[]{1,2,3}, new int[]{3,2,7}, 4));
    }
}
