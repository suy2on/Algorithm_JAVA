package LV2;

import java.util.Arrays;

public class Six {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // 정렬

        int i = 0;
        for(int citation : citations){
            if(citations.length - i < citation) break;
            i++;
        }



        return citations.length - i;
    }
}
