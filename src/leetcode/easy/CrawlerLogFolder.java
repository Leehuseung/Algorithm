package leetcode.easy;

/**
 * 1598. Crawler Log Folder
 */
public class CrawlerLogFolder {

    public static int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if(log.equals("../") && depth != 0){
                depth--;
                continue;
            } else if(log.equals("../")){
                continue;
            }
            if(log.equals("./")){
                continue;
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        System.out.println(minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(minOperations(new String[]{"d1/","../","../","../"}));
    }
}
