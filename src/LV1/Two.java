package LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Two {
    public int[] Two(int[] lottos, int[] win_nums) {
        int zero = 0;
        int correct = 0;

        List<Integer> win = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        for(int num : lottos){
            if(num == 0){
                zero++;
            }
            else{
                if(win.contains(num)){
                    correct++;
                }
            }
        }
        int []answer = new int[2];
        answer[0] = 7 - correct;
        answer[1] = 7 - zero - correct;

        if(answer[0] == 7){
            answer[0] = 6;
        }
        if(answer[1] == 7){
            answer[1] = 6;
        }

        return answer;
    }



}
