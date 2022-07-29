package leetcode.easy;

import java.util.LinkedList;

/**
 * 682. Baseball Game
 */
public class BaseballGame {
    public static int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < ops.length; i++) {
            if(ops[i].equals("D")){
                int d = list.getLast() * 2;
                list.add(d);
            } else if(ops[i].equals("C")){
                list.removeLast();
            } else if(ops[i].equals("+")){
                int p = list.get(list.size()-1) + list.get(list.size()-2);
                list.add(p);
            } else {
                list.add(Integer.parseInt(ops[i]));
            }
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"})); // 30
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"})); // 27
        System.out.println(calPoints(new String[]{"1","C"})); // 0
    }
}
