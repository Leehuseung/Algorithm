package programmers.lv1;

/**
 * Lv1. 카드 뭉치
 */
public class DeckOfCards {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardOne = 0;
        int cardTwo = 0;
        int goalIndex = 0;

        while(goalIndex < goal.length-1){
            String goalString = goal[goalIndex++];
            if(cardOne < cards1.length && goalString.equals(cards1[cardOne])){
                cardOne++;
                continue;
            }
            if(cardTwo < cards2.length && goalString.equals(cards2[cardTwo])){
                cardTwo++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"i", "drink", "water"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        ));
        System.out.println(solution(
                new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        ));
    }
}
