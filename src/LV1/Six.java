package LV1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Six {
    public int solution(int[][] board, int[] moves) {
        int i,j;
        int answer = 0;
        int N = board[0].length;
        List<Integer> ceiling = new ArrayList<>();
        Stack<Integer> box = new Stack<>();

        // 각 행 맨위에 인덱스 저장
        for(i=0; i<N; i++){
            ceiling.add(-1);
            for(j=0; j<N; j++){
                if(board[j][i] !=0){
                    ceiling.set(ceiling.size()-1,j);
                    break;
                }
            }
        }

        System.out.println(ceiling.toString());

        // 인형뽑기 시작
        for(int move : moves){
            if(ceiling.get(move-1) == -1){
                continue;
            }
            int doll = board[ceiling.get(move-1)][move-1];
            if(ceiling.get(move-1) == N-1){
                ceiling.set(move-1, -1);
            }
            else{
                ceiling.set(move-1, ceiling.get(move-1)+1);
            }

            if(!box.isEmpty() && box.peek() == doll){
                box.pop();
                answer += 2;
            }
            else box.push(doll);



        }

        return answer;

    }

}
