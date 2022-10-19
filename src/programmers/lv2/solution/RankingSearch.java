package programmers.lv2.solution;

import java.util.*;

/**
 * Lv2. 순위 검색
 *
 * 22.07.20
 *
 * 22.07.22 조합 참고
 *
 * 22.07.25 이진검색 참고
 */
public class RankingSearch {
    static HashMap<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            String[] infoDetail = info[i].split(" ");
            recursion(infoDetail,0,"");
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            Collections.sort(value);
        }

        for (int i = 0; i < query.length; i++) {
            String a = query[i];
            a = a.replaceAll(" and ", "");
            String[] arr = a.split(" ");
            String key = arr[0];
            Integer value = Integer.parseInt(arr[1]);

            if(map.containsKey(key)){
                List<Integer> integerList = map.get(key);
                int pr = 0;
                int pl = integerList.size()-1;
                while(pr <= pl){
                    int pc = (pr + pl) / 2;
                    if(integerList.get(pc) < value){
                        pr = pc + 1;
                    } else {
                        pl = pc - 1;
                    }
                }
                answer[i] = integerList.size()-pr;
            }
        }
        return answer;
    }

    private static void recursion(String[] infoDetail, int i, String s) {
        if(i == 4){
            if(map.containsKey(s)){
                List<Integer> arr = map.get(s);
                arr.add(Integer.parseInt(infoDetail[4]));
            } else {
                //키가 없다면 정수 배열을 넣어 준다.
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(Integer.parseInt(infoDetail[4]));
                map.put(s,arr);
            }
            return;
        }

        recursion(infoDetail,i+1,s+"-");
        recursion(infoDetail,i+1,s+infoDetail[i]);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]
                        {
                            "java backend junior pizza 150"
                            ,"python frontend senior chicken 210"
                            ,"python frontend senior chicken 150"
                            ,"cpp backend senior pizza 260"
                            ,"java backend junior chicken 80"
                            ,"python backend senior chicken 50"
                        },
                new String[]
                        {
                            "java and backend and junior and pizza 100",
                            "python and frontend and senior and chicken 200",
                            "cpp and - and senior and pizza 250",
                            "- and backend and senior and - 150",
                            "- and - and - and chicken 100",
                            "- and - and - and - 150"
                        }))); //[1,1,1,1,2,4]
    }
}
