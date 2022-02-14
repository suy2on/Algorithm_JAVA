package LV2;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();

        test.add(1);
        test.add(2);
        test.add(3);

        System.out.println(test.pop());
        for(int i : test){
            System.out.println(i);
        }
    }
}
