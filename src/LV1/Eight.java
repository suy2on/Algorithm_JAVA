package LV1;

import java.util.Arrays;

public class Eight {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i;

        for(i=0; i<commands.length; i++){
            int [] parse = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(parse);
            answer[i] = parse[commands[i][2]-1];
        }

        return answer;
    }

}
