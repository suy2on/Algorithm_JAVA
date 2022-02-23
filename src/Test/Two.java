package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Two {
    public class Stock{
        String msg ="";
        String action;
        String name;
        int overlap = 0;

        public Stock(String name, String action) {
            this.action = action;
            this.name = name;
        }

        public void setMsg(String other) {
            if(action.equals("share")){
                if(overlap == 0) msg = name + " shared your post";
                else if(overlap == 1) msg = name + " and " +other+ " shared your post";
                else msg = name + " and " + overlap + " others shared your post";
            }
            else{
                if(overlap == 0) msg = name + " commented on your post";
                else if(overlap == 1) msg = name + " and " +other+ " commented on your post";
                else msg = name + " and " + overlap + " others commented on your post";
            }

        }
    }

    public String[] solution(String[] records) {
        List<String> answer = new ArrayList<>();
        Stack<Stock> alarm = new Stack<>();
        Stack<Stock> storage = new Stack<>();

        for(String record : records){
            String name = record.split(" ")[0];
            String action = record.split(" ")[1];

            if(alarm.isEmpty()){
                alarm.push(new Stock(name, action));
                alarm.peek().setMsg(name);
                continue;
            }

            if(name.equals("check")){ // 보관함이동
                storage.push(alarm.pop());
            }
            else{// 알람추가
                if(alarm.peek().action.equals(action)){
                    alarm.peek().overlap++;
                }
                else{
                    alarm.push(new Stock(name, action));
                }
                alarm.peek().setMsg(name);
            }

        }
        for(Stock st : storage){
            answer.add(st.msg);
        }

        return answer.stream().toArray(String[]::new);
    }

}
