package leetcode.easy;

/**
 * 1678. Goal Parser Interpretation
 */
public class GoalParserInterpretation {

    public static String interpret(String command) {
        return command.replaceAll("\\(\\)","o").replaceAll("\\(al\\)","al");
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));        //Goal
        System.out.println(interpret("G()()()()(al)"));  //Gooooal
        System.out.println(interpret("(al)G(al)()()G")); //alGalooG
    }
}
