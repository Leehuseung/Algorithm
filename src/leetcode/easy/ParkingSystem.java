package leetcode.easy;

/**
 * LeetCode Easy 1603. Design Parking System
 */
public class ParkingSystem {

    private int big;
    private int nowBig;
    private int medium;
    private int nowMedium;
    private int small;
    private int nowSmall;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        this.nowBig = 0;
        this.nowMedium = 0;
        this.nowSmall = 0;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1 :
                this.nowBig++;
                return nowBig > big ? false : true;
            case 2 :
                this.nowMedium++;
                return nowMedium > medium ? false : true;
            case 3 :
                this.nowSmall++;
                return nowSmall > small ? false : true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1, 1, 0);
    }
}
