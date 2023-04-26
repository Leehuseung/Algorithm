package leetcode.easy;

import java.util.Arrays;

/**
 * 2469. Convert the Temperature
 */
public class ConvertTheTemperature {
    public static double[] convertTemperature(double celsius) {
        double[] an = new double[2];
        an[0] = celsius + 273.15;
        an[1] = celsius * (1.8) + 32.00;
        return an;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(convertTemperature(36.50)));
        System.out.println(Arrays.toString(convertTemperature(122.11)));
    }
}
