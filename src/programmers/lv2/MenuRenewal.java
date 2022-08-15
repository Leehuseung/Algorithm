package programmers.lv2;

import java.util.*;

/**
 * Lv2. 메뉴 리뉴얼
 */
public class MenuRenewal {

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        HashSet<String> set = new HashSet<>();
        HashMap<String,Integer>[] mapArr = new HashMap[course.length];

        //모든 조합 순회함.
        for (int i = 0; i < course.length; i++) {
            HashMap<String,Integer> map = new HashMap<>();
            mapArr[i] = map;
            for (int j = 0; j < orders.length; j++) {
                String order = orders[j];
                recur(order, "",course[i],0,0, map);
            }
        }

        //각 조합에 최대 갯수를 가져온다.
        int[] maxArr = new int[course.length];
        for (int i = 0; i < mapArr.length; i++) {
            HashMap<String,Integer> map = mapArr[i];
            int max = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() > 1 && entry.getValue() > max){
                    max = entry.getValue();
                }
            }
            maxArr[i] = max;
        }

        for (int i = 0; i < mapArr.length; i++) {
            HashMap<String,Integer> map = mapArr[i];
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(maxArr[i] == entry.getValue()){
                    set.add(entry.getKey());
                }
            }
        }

        answer = new String[set.size()];

        int i = 0;
        for(String value : set) {
            answer[i] = value;
            i++;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void recur(String word,String answer,int depth,int nowDepth, int index,HashMap<String,Integer> map){
        if(nowDepth == depth){
            char[] carr = answer.toCharArray();
            Arrays.sort(carr);
            String a = new String(carr);
            map.put(a,map.get(a) == null ? 1 : map.get(a)+1);
            return;
        }
        nowDepth++;
        for (int i = index; i < word.length(); i++) {
            recur(word,answer + word.charAt(i)+"",depth,nowDepth,i+1,map);
        }
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4}))); //["AC", "ACDE", "BCFG", "CDE"]
//        System.out.println(Arrays.toString(solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5}))); //["ACD", "AD", "ADE", "CD", "XYZ"]
//        System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XWY", "WXA"}, new int[]{2,3,4}))); //["WX", "XY"]

        System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XWY", "WXA"}, new int[]{1}))); //["WX", "XY"]


    }
}
