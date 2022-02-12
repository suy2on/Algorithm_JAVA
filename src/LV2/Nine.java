package LV2;

import java.util.HashMap;
import java.util.Map;

public class Nine {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> pairs = new HashMap<>();

        for(String[] cloth : clothes){
            pairs.put(cloth[1], pairs.getOrDefault(cloth[1],0) + 1);
        }

        for(int num : pairs.values()){
            answer *= num+1;
        }
        return answer - 1;
    }
}
