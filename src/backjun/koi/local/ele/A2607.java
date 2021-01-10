package backjun.koi.local.ele;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A2607 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Character,Integer> firstMap = new HashMap<>();
        HashMap<Character,Integer> compareMap = null;


        int a = Integer.parseInt(sc.nextLine());
        int result = 0;

        String compareWord = "";
        String firstWord = sc.nextLine();

        //첫째 단어를 Map으로 변경
        for (int i = 0; i < firstWord.length(); i++) {
            if(firstMap.containsKey(firstWord.charAt(i))){
                int key = firstMap.get(firstWord.charAt(i));
                firstMap.put(firstWord.charAt(i),++key);
            } else {
                firstMap.put(firstWord.charAt(i),1);
            }
        }

        //첫째 단어로 만든 맵에서 비교할 단어를 지우면서 map의 사이즈로 결과를 판단함.
        for(int i = 0 ; i < a-1; i++){
            compareWord = sc.nextLine();
            compareMap = (HashMap<Character, Integer>) firstMap.clone();

            if(firstWord.length() == compareWord.length()) {
                result = result + doCompareWord(compareWord,compareMap,2);
            //길이가 작을때
            } else if(firstWord.length() == compareWord.length()+1){
                result = result + doCompareWord(compareWord,compareMap,2);
            //길이가 길때
            } else if(firstWord.length() == compareWord.length()-1){
                result = result + doCompareWord(compareWord,compareMap,1);
            }
        }
        System.out.println(result);
    }

    private static int doCompareWord(String compareWord, HashMap<Character, Integer> compareMap, int i) {
        int result = 0;
        for (int j = 0; j < compareWord.length(); j++) {
            if(compareMap.containsKey(compareWord.charAt(j)) && compareMap.get(compareWord.charAt(j)) > 1){
                int num = compareMap.get(compareWord.charAt(j));
                compareMap.put(compareWord.charAt(j),--num);
            } else {
                compareMap.remove(compareWord.charAt(j));
            }
        }
        if(compareMap.size() < i){
            for(Map.Entry<Character,Integer> entry : compareMap.entrySet()){
                if(entry.getValue() > 1){
                    return 0;
                }
            }
            result++;
        }
        return result;
    }
}

