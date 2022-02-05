package LV2;

import java.util.LinkedList;
import java.util.Queue;

public class Two {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int truck_idx = 0;
        Queue<Integer> bridge = new LinkedList<>();

        // 맨앞트럭 진입
        int b_weight = truck_weights[truck_idx];
        bridge.add(truck_weights[truck_idx]);
        truck_idx++;

        while(b_weight != 0) {
            if (bridge.size() == bridge_length) { // 꽉찬경우에는 앞에 빼주기
                b_weight -= bridge.peek();
                bridge.poll();
            }

            // 뒤에 넣어주기
            if(truck_idx < truck_weights.length) {
                if (b_weight + truck_weights[truck_idx] <= weight) { // 무게 차기 전
                    bridge.add(truck_weights[truck_idx]);
                    b_weight += truck_weights[truck_idx];
                    truck_idx++;
                } else { // 무게 찬 경우
                    bridge.add(0);
                }
            }
            else{
                bridge.add(0);
            }
            time++;
        }

        return time;
    }


    // 객체지향적 풀이
    
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution2(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }

}
