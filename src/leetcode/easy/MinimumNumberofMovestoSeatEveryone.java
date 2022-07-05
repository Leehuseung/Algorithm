package leetcode.easy;

import java.util.Arrays;

/**
 * 2037. Minimum Number of Moves to Seat Everyone
 */
public class MinimumNumberofMovestoSeatEveryone {

    public static int minMovesToSeat(int[] seats, int[] students) {
        int answer = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < seats.length; i++) {
            answer += Math.abs(seats[i]-students[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[]{3,1,5},new int[]{2,7,4}));       // 4
        System.out.println(minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6}));  // 7
        System.out.println(minMovesToSeat(new int[]{2,2,6,6},new int[]{1,3,2,6}));   // 4
        System.out.println(minMovesToSeat(new int[]{12,14,19,19,12},new int[]{19,2,17,20,7})); // 19
    }

}
