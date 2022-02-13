package LV1;

import java.util.HashMap;
import java.util.Map;

public class Twoleve {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Map<Integer,Integer> student = new HashMap<>();

        for(int i=1; i<n+1; i++){
            student.put(i,1);
        }

        for(int num: lost){
            student.put(num, student.get(num)-1);
        }

        for(int num: reserve){
            student.put(num, student.get(num)+1);
        }


        for(int i=n; i>0; i--){
            if(student.get(i) == 0){
                if(student.getOrDefault(i-1,3) == 2){
                    student.put(i, 1);
                    student.put(i-1, 1);
                }
                else if(student.getOrDefault(i+1,3) == 2) {
                    student.put(i, 1);
                    student.put(i + 1, 1);
                }

            }

            if(student.get(i) == 0) answer --;
        }

        return answer;
    }
}
