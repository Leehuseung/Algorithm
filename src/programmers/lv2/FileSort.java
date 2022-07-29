package programmers.lv2;

import java.util.*;

/**
 * Lv2. [3차] 파일명 정렬
 */
public class FileSort {

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<HashMap<String,String>> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            HashMap<String,String> map = new HashMap();
            String fileName = files[i];
            int startIntegerIdx = -1;
            int lastIntegerIdx = -1;

            for (int j = 1; j < fileName.length()-1; j++) {

                if(!Character.isDigit(fileName.charAt(j)) && Character.isDigit(fileName.charAt(j+1))){
                    startIntegerIdx = j+1;
                }

                if(startIntegerIdx != -1 && (Character.isDigit(fileName.charAt(j))) && !Character.isDigit(fileName.charAt(j+1))){
                    lastIntegerIdx = j;
                }

                if(startIntegerIdx != -1 && (j == fileName.length()-2 && lastIntegerIdx == -1)){
                    lastIntegerIdx = fileName.length()-1;
                }

                if(lastIntegerIdx != -1){
                    break;
                }
            }
            map.put("head",fileName.substring(0,startIntegerIdx));
            map.put("number",fileName.substring(startIntegerIdx,lastIntegerIdx+1));
            map.put("tail",fileName.substring(lastIntegerIdx+1));
            list.add(map);
        }

        Collections.sort(list, (o1, o2) -> {
            String o1Head = o1.get("head").toLowerCase();
            String o2Head = o2.get("head").toLowerCase();
            int compareString = o1Head.compareTo(o2Head);
            if(compareString == 0){
                int o1Number = Integer.parseInt(o1.get("number"));
                int o2Number = Integer.parseInt(o2.get("number"));
                if(o1Number > o2Number){
                    return 1;
                } else if (o1Number < o2Number){
                    return -1;
                }
                return 0;
            } else {
                return compareString;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            HashMap<String,String> map = list.get(i);
            answer[i] = map.get("head") + map.get("number") + map.get("tail");
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}))); //["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
        System.out.println(Arrays.toString(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}))); //["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]


    }
}
