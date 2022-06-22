package leetcode.easy;

import java.util.List;

/**
 * 1773. Count Items Matching a Rule
 */
public class CountItemsMatchingaRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int answer = 0;

        for (int i = 0; i < items.size(); i++) {
            List<String> item = items.get(i);
            String type = item.get(0);
            String color = item.get(1);
            String name = item.get(2);

            switch (ruleKey) {
                case "type" :
                    if(ruleValue.equals(type)){
                        answer++;
                    }
                    break;
                case "color" :
                    if(ruleValue.equals(color)){
                        answer++;
                    }
                    break;
                case "name" :
                    if(ruleValue.equals(name)){
                        answer++;
                    }
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        //바로코딩
    }
}
