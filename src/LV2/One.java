package LV2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class One {
    public int solution(int[] priorities, int location) {
        int[] target = new int[2];
        Stack<int[]> st = new Stack<>();
        Queue<int[]> q = new LinkedList<>();

        int idx = 0;

        for(int priority : priorities){
            if(idx == location){
                target[0] = priority;
                target[1] = idx;
                q.add(target);
            }
            else {
                q.add(new int[]{priority, idx});
            }
            idx++;
        }

        while(!q.isEmpty()){
            while(!st.isEmpty() && q.peek()[0] > st.peek()[0]) q.add(st.pop());
            st.push(q.poll());
        }


        return st.size() - st.search(target) + 1;
    }


    public int solution2 (int[] priorities, int location){

        Queue<int[]> queue = new LinkedList<>();
        int idx = 0;
        int count = 0;


        for(int priority : priorities){
            queue.offer(new int[]{priority, idx});
            idx++;
        }

        while(!queue.isEmpty()){
            Boolean print = Boolean.TRUE;
            for(int [] element : queue){
                if(queue.peek()[0] < element[0]){
                    print = Boolean.FALSE;
                    break;
                }
            }

            if(print){
                int [] out = queue.poll();
                count++;
                if(out[1] == location){
                    return count;
                }
            }
            else{
                queue.offer(queue.poll());
            }

        }

        return 0;
    }



}

