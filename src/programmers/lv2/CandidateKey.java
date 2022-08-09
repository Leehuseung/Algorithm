package programmers.lv2;

import java.util.*;

/**
 * Lv2. 후보키
 *
 * 22.07.11
 *
 * 22.08.04 실패 케이스 힌트 참고.
 */
public class CandidateKey {
    static List<String> uniqueList = new ArrayList<>();
    static boolean[] bools;
    static int[] arr;
    public static int solution(String[][] relation) {
        arr = new int[relation[0].length];
        bools = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                backtrack(relation, j,arr[j] + "",i);
            }
        }

        return uniqueList.size();
    }


    private static boolean isUnique(String[][] relation, String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            String key = "";
            for (int j = 0; j < s.length(); j++) {
                int k = Integer.parseInt(s.charAt(j) + "");
                key += relation[i][k];
            }
            if(set.contains(key)){
                return false;
            } else {
                set.add(key);
            }
        }
        return true;
    }

    private static void backtrack(String[][] relation, int idx, String s,int len) {
        bools[idx] = true;
        if(s.length() == len){
            if(isUnique(relation,s)) {
                for (int i = 0; i < uniqueList.size(); i++) {
                    char[] unique = uniqueList.get(i).toCharArray();
                    boolean result = true;
                    for (int j = 0; j < unique.length; j++) {
                        String ss = unique[j]+"";
                        if(!s.contains(ss)){
                            result = false;
                        }
                    }
                    if(result){
                        return;
                    }
                }
                uniqueList.add(s);
            }
        }

        for (int j = idx+1; j < arr.length; j++) {
            if(!bools[j]){
                backtrack(relation,j,s+arr[j],len);
                bools[j] = false;
            }
        }
        bools[idx] = false;
    }

    public static void main(String[] args) {
        System.out.println("정답 : "+ solution(new String[][] {
                         {"100","ryan","music","2"}
                        ,{"200","apeach","math","2"}
                        ,{"300","tube","computer","3"}
                        ,{"400","con","computer","4"}
                        ,{"500","muzi","music","3"}
                        ,{"600","apeach","music","2"}
                })); //2

//        System.out.println(solution(new String[][]{{"a","1","aaa","c","ng"},{"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}})); // 3
//        System.out.println(solution(new String[][]{
//                {"a","1","aaa","c","ng"},
//                {"a","1","bbb","e","g"},
//                {"c","1","aaa","d","ng"},
//                {"d","2","bbb","d","ng"}})); // 5

    }
}

