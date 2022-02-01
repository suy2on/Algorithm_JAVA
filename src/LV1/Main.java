package LV1;

import java.sql.Array;

public class Main {
    public static void main(String[] args) {
        Five five = new Five();
        int [] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(five.sol(numbers, hand));
    }
}
