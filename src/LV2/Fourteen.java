package LV2;

public class Fourteen {
    int answer = 0;
    int target;

    public void dfs(int total, int i, int[] numbers){
        if(i >= numbers.length){
            if(total == target) answer++;
            return;
        }
        dfs(total+numbers[i], i+1, numbers);
        dfs(total-numbers[i], i+1, numbers);
    }

    public int solution(int[] numbers, int target) {
        this.target = target;

        dfs(0,0, numbers);

        return answer;
    }
}
