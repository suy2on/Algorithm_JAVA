package Test;

import java.util.*;

public class Three {
    public class Path{
        int now;
        int past;
        int psg = 0;

        public Path(int now, int past) {
            this.now = now;
            this.past = past;
        }
    }
    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {1,0};
        Queue<Path> paths = new LinkedList<>();

        HashMap<Integer, List<Integer>> info = new HashMap<>();


        // 연결정보
        for(int[] tr : train){
            List<Integer> tmp;
            if(info.get(tr[0]) == null){
                tmp = new ArrayList<>();
            }
            else{
                tmp = info.get(tr[0]);
            }
            tmp.add(tr[1]);
            info.put(tr[0],tmp);

            if(info.get(tr[1]) == null){
                tmp = new ArrayList<>();
            }
            else{
                tmp = info.get(tr[1]);
            }
            tmp.add(tr[0]);
            info.put(tr[1],tmp);
        }

        // 초기화
        for(int child : info.get(1)){
            Path nPath = new Path(child,1);
            nPath.psg = passenger[0];
            paths.offer(nPath);
            info.get(child).remove(Integer.valueOf(1));
        }

        // bfs
        while(!paths.isEmpty()){
            int count = paths.size();
            System.out.println(count);
            System.out.println(info.toString());
            for(int i=0; i<count; i++){
                Path now = paths.poll();
                if(info.get(now.now).size() == 0){ // 최대갱신
                    now.psg += passenger[now.now-1];
                    if(now.psg > answer[1]){
                        answer[0] = now.now;
                        answer[1] = now.psg;
                    }
                    else if(now.psg == answer[1]){
                        answer[0] = Math.max(now.now, answer[0]);
                    }
                    continue;
                }
                for( int child : info.get(now.now)){ // 자식순회
                    Path nPath = new Path(child,now.now);
                    nPath.psg = now.psg + passenger[now.now-1];
                    paths.offer(nPath);
                    info.get(child).remove(Integer.valueOf(now.now));
                }
            }
        }

        return answer;
    }
}
