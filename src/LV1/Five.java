package LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Five {
    public int len(int mid, int hand){
        System.out.println(String.format("%d  %d" , mid, hand));
        int mid_step = mid / 3;
        int mid_lr = 1;
        int hand_step = hand /3;
        int hand_lr = (hand-1) % 3;

        if(mid == 0) {mid_step = 3;}
        if(hand == 0){
            hand_step = 3;
            hand_lr = 1;
        }

        System.out.println(String.format("%d  %d  %d  %d", mid_step, hand_step, mid_lr, hand_lr));
        //System.out.println(Math.abs(mid_lr - hand_lr) + Math.abs(mid_step - hand_step));
        return Math.abs(mid_lr - hand_lr) + Math.abs(mid_step - hand_step);
    }

    public String sol(int[] numbers, String hand) {

        ArrayList<Integer> left_key = new ArrayList<>(Arrays.asList(1, 4, 7));
        ArrayList<Integer> right_key = new ArrayList<>(Arrays.asList(3, 6, 9));
        int i;
        int left = 10;
        int right = 12;
        String answer = "";




        for(i=0; i<numbers.length; i++){
            if(left_key.contains(numbers[i]))  {
                answer += "L";
                left = numbers[i];
            }
            else if(right_key.contains(numbers[i])) {
                answer += "R";
                right = numbers[i];
            }
            else {
                if(len(numbers[i],left) > len(numbers[i],right)){
                    answer += "R";
                    right = numbers[i];
                }
                else if(len(numbers[i],left) < len(numbers[i],right)){
                    answer += "L";
                    left = numbers[i];
                }
                else{
                    if(hand.equals("left")) {
                        answer += "L";
                        left = numbers[i];
                    }
                    else{
                        answer += "R";
                        right = numbers[i];
                    }
                }
            }

        }


        return answer;
    }

}




