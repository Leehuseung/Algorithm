package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KeyboardRow {
    public static String[] findWords(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        String one = "qwertyuiop";
        String two = "asdfghjkl";
        String three = "zxcvbnm";
        makeHashMap(map, one,1);
        makeHashMap(map, two,2);
        makeHashMap(map, three,3);

        List<String> list = new ArrayList<>();
        loop:
        for (String s : words) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length-1; i++) {
                String k = chars[i]+"";
                String t = chars[i+1]+"";
                if(map.get(k.toLowerCase()) != map.get(t.toLowerCase())){
                    continue loop;
                }
            }
            list.add(s);
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void makeHashMap(HashMap<String,Integer> map, String s, Integer i){
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar+"",i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
    }
}
