package LV2;

import java.util.Arrays;

public class Six {
    public int solution(int[] citations) {
        int answer = 0;
        citations = Arrays.stream(citations).sorted().toArray(); // 정렬

        int i = 0;
        for(int citation : citations){
            if(citations.length - i < citation) break;
            i++;
        }



        return citations.length - i;
    }
}
