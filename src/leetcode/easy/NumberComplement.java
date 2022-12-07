package leetcode.easy;

/**
 * 476. Number Complement
 */
public class NumberComplement {
    public static int findComplement(int num) {
        String bi = Integer.toBinaryString(num);
        bi = bi.replaceAll("0","2").replaceAll("1","0").replaceAll("2","1");
        return Integer.parseUnsignedInt(bi,2);
    }
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
