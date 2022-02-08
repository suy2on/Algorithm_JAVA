package LV2;

import java.util.Arrays;
import java.util.Comparator;

public class Four {

    public String solution(int[] numbers) {
        String answer = "";
        String [] snumbers = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            snumbers[i] = String.valueOf(numbers[i]);
        }


        Arrays.sort(snumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2); // 내림차순
            }
        });

        if(snumbers[0].equals("0")) return "0"; // 예외처리

        for(String str : snumbers){
            answer += str;
        }
        return answer;
    }


}
