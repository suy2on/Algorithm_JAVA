package LV1;

import java.util.*;
import java.util.stream.Collectors;

public class One {

    public int[] One(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int i;

        Map<String, HashSet<String>> pairs = new HashMap<>();
        HashMap<String, Integer> singo = new HashMap<>();


        for (i = 0; i < report.length; i++) {
            String[] pair = report[i].split(" ");

            if(pairs.get(pair[0]) == null){
                pairs.put(pair[0], new HashSet<String>());
            }

            pairs.get(pair[0]).add(pair[1]);

        }

        for(Map.Entry<String, HashSet<String>> entry : pairs.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }



        for(HashSet<String> names : pairs.values()) {

            for (String name : names) {
                singo.put(name, singo.getOrDefault(name, 0) + 1);
            }

        }

        for (i = 0; i < id_list.length; i++) {
            int count = 0;
            for (String name : pairs.getOrDefault(id_list[i], new HashSet<>())) {
                if (singo.get(name) > 1) {
                    count++;
                }
            }
            answer[i] = count;
            System.out.println(count);
        }

        return answer;

    }



}


