package LV2;

import java.util.Stack;

public class Eleven {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> nums = new Stack();
        int remove = 0;
        int i;

        if(number.length() == 1){
            return number;
        }

        for(i=0; i<number.length(); i++){
            while(remove < k && !nums.isEmpty() && Character.compare(nums.peek(), number.charAt(i)) < 0){
                nums.pop();
                remove++;
            }

            if(remove >= k) break;

            nums.push(number.charAt(i));
        }

        for(Character c : nums){
            answer += Character.toString(c);
        }


        if(remove < k) return answer.substring(0,answer.length()-1);

        return answer + number.substring(i);
    }
}
