package LV2;

import java.util.HashMap;
import java.util.Map;

public class Ten {
    private int i = 0;
    private Map<Character,Integer[]> idx = new HashMap<>();

    public int upOrDown(Character c){
        return Math.min(idx.get(c)[0], -idx.get(c)[1]);
    }
    public void left(int len){
        i--;
        i = i % len;
    }

    public void right(int len){
        i++;
        i = i % len;
    }


    public int solution(String name) {
        int answer = 0;
        int tmp = 0;
        int match = name.length();

        for(int i =65; i<91; i++){
            int pos = i - 65;
            int neg = -(26 - pos);
           // Integer[] pair = new Integer[] {pos,neg};
            idx.put((char)i, new Integer[]{pos,neg});
        }

        while(match != 0){
            while(Character.compare(name.charAt(tmp),'A') == 0){
                tmp++;
            }
            if(tmp-i < name.length()-tmp+i){

            }

        }



        return answer;
    }
}
