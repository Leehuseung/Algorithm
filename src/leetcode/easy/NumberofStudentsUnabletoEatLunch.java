package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1700. Number of Students Unable to Eat Lunch
 */
public class NumberofStudentsUnabletoEatLunch {

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> sandwicheQueue = new LinkedList<>();
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int sandwich : sandwiches)  sandwicheQueue.add(sandwich);
        for (int student : students) studentQueue.add(student);

        int cnt = 0;
        while(cnt != studentQueue.size()) {
            if(sandwicheQueue.peek().equals(studentQueue.peek())){
                sandwicheQueue.poll();
                studentQueue.poll();
                cnt = 0;
            } else {
                cnt++;
                studentQueue.add(studentQueue.poll());
            }
        }

        return studentQueue.size();
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,1,0,0,1},new int[]{1,0,0,0,1,1}));
    }
}
