package leetcode.easy;

/**
 * LeetCode Easy 2011. Final Value of Variable After Performing Operations
 */
public class FinalValueofVariableAfterPerformingOperations {

    public static int finalValueAfterOperations(String[] operations) {
        int answer = 0;

        for (String operation : operations) {
            switch (operation) {
                case "X--" :
                case "--X" :
                    answer--;
                    break;
                case "X++" :
                case "++X" :
                    answer++;
                    break;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X","X++","X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"++X","++X","X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"X++","++X","--X","X--"}));
    }
}
