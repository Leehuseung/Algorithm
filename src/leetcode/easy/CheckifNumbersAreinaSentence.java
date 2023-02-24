package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2042. Check if Numbers Are Ascending in a Sentence
 */
public class CheckifNumbersAreinaSentence {

    public static boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            try{
                list.add(Integer.parseInt(arr[i]));
            }catch (Exception e){}
        }

        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles");
    }
}
