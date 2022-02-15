package LV2;

import java.util.PriorityQueue;

public class Thirteen {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> foods = new PriorityQueue<>();

        for(int s : scoville){
            foods.offer(s);
        }

        while(foods.peek() < K){
            try {
                foods.offer(foods.poll() + foods.poll() * 2);
                answer++;
            } catch (Exception e){
                return -1;
            }
        }
        return answer;
    }
}
