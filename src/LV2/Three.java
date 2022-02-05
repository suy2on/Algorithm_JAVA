package LV2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Three {
    class Stock{
        int price;
        int idx;
        int period = 0;

        public Stock(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }

        public void pass_by(){
            period++;
         }

    }

    public Stack<Stock> pushStock(Stack<Stock> stack, Stock newStock){
        Stack<Stock> tmp = new Stack<>();

        while(newStock.price < stack.peek().price) tmp.push(stack.pop());
        stack.push(newStock);
        while(!tmp.isEmpty()) stack.push(tmp.pop());

        return stack;
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> pastST = new Stack<>();
        Queue<Stock> futureQ = new LinkedList<>();

        for(int i=0; i<prices.length; i++){
            futureQ.offer(new Stock(prices[i], i));
        }

        // 주식 끝까지 돌기
        while(!futureQ.isEmpty()){

            // 비어있으면
            if(pastST.isEmpty()){
                pastST.add(futureQ.poll());
                continue;
            }

            // stock이 모두 버텼다
            for(Stock stock : pastST){
                stock.period++;
            }

            // 하락하면 pop
            while(!pastST.isEmpty() && futureQ.peek().price < pastST.peek().price){  // 중간에 stack 빌수있음 주의 !!!!!
                Stock rmStock = pastST.pop();
                answer[rmStock.idx] = rmStock.period;
            }

            pastST.push(futureQ.poll());
        }

        // 남아있는 주식들 다 계산
        for(Stock remain : pastST){
            answer[remain.idx] = remain.period;
        }

        return answer;
    }

    public int[] solution2(int[] prices) {

        int [] result = new int[prices.length];

        for(int i =0; i<prices.length; i++){
            for(int j = i+1; j<prices.length; j++){
                result[i]++;
                if(prices[i] < prices[j]) break;
            }
        }

        return result;
    }
}
