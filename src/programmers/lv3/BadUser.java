package programmers.lv3;
import java.util.*;

/**
 * Lv3. 불량 사용자
 */
public class BadUser {
    static List<List<String>> list = new ArrayList<>();
    static Set<String> totalSet = new HashSet<>();
    public static int solution(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) list.add(new ArrayList<>());
        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) if(isBan(banned_id[i],user_id[j])) list.get(i).add(user_id[j]);
        }
        recursive(list.get(0),0,new ArrayList<>());
        return totalSet.size();
    }

    private static void recursive(List<String> subList, int i, List<String> t) {
        for (int j = 0; j < subList.size(); j++) {
            String s = subList.get(j);
            if(!t.contains(s)){
                t.add(s);
            } else {
                continue;
            }
            if((i+1) == list.size()) {
                String sum = t.stream().sorted().reduce("",((s1, s2) -> s1 + s2));
                totalSet.add(String.join("",sum));
                t.remove(s);
                continue;
            }
            recursive(list.get(i+1),i+1,t);
            t.remove(s);
        }
    }

    private static boolean isBan(String banId, String userId) {
        if(banId.length() != userId.length()) return false;
        for (int i = 0; i < banId.length(); i++) {
            if(banId.charAt(i) == '*') continue;
            if(banId.charAt(i) != userId.charAt(i)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"})); //2
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})); //2
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})); //3
    }
}
