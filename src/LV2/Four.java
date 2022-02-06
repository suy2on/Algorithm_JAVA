package LV2;

import java.util.Arrays;
import java.util.Comparator;

public class Four implements Comparator<String> {

    public String solution(int[] numbers) {
        String answer = "";
        String [] snumbers = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            snumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(snumbers);

        for(String str : snumbers){
            System.out.println(str);
        }

        for(String str : snumbers){
            answer += str;
        }
        return answer;
    }

    @Override
    public int compare(String s1, String s2){
        if((s1+s2).compareTo(s2+s1) >= 0 ) {
            return 1;
        }
        else{
            return -1;
        }

    }

}
