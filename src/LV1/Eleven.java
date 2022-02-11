package LV1;

import java.util.HashMap;

public class Eleven {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> freqs = new HashMap<>();

        for(String name : participant){
            freqs.put(name, freqs.getOrDefault(name,0) + 1);
        }

        for(String name : completion){
            freqs.put(name, freqs.get(name) - 1);
        }

        for(String name : freqs.keySet()){
            if(freqs.get(name) != 0){
                answer = name;
                break;
            }
        }

        return answer;
    }

}
