package LV1;

import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Ten {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deploy = new ArrayList<>();
        List<int []> worksQueue = new ArrayList<>();

        for(int i= 0; i<progresses.length; i++){
            worksQueue.add(new int[]{progresses[i], speeds[i]});
        }

        while(worksQueue.size() != 0){ // 매일
            for(int i =0; i<worksQueue.size(); i++){
                int [] work = worksQueue.get(i);
                worksQueue.set(i, new int[]{work[0] + work[1], work[1]}); // 일하기
            }

            int i = 0;
            while(worksQueue.get(i)[0] > 100){
                i++;
            }
            deploy.add(i);
            for(; i>0; i--){
                worksQueue.remove(0);
            }
        }


        return deploy.stream().mapToInt(i->i).toArray();


    }
}
