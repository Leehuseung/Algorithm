package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2103. Rings and Rods
 */
public class RingsandRods {

    public static int countPoints(String rings) {
        int answer = 0;

        Rod[] rods = new Rod[10];

        for (int i = 0; i < rods.length; i++) {
            rods[i] = new Rod();
        }

        for (int i = 0; i < rings.length(); i += 2) {
            String color = rings.charAt(i) + "";
            Integer number = Integer.parseInt(String.valueOf(rings.charAt(i+1)));
            rods[number].add(color);
        }

        for (int i = 0; i < rods.length; i++) {
            if(rods[i].isThree()){
                answer++;
            }
        }

        return answer;
    }

    static class Rod {
        List<String> list = new ArrayList<>();

        public void add(String a){
            list.add(a);
        }

        public boolean isThree(){
            boolean r = false;
            boolean b = false;
            boolean g = false;
            for (int i = 0; i < list.size(); i++) {
                String color = list.get(i);
                switch (color){
                    case "R" :
                        r = true;
                        break;
                    case "B" :
                        b = true;
                        break;
                    case "G" :
                        g = true;
                        break;
                }
            }
            if(r && b && g){
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9")); //1
        System.out.println(countPoints("B0R0G0R9R0B0G0")); //1
    }
}
