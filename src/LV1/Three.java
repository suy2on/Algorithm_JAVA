package LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Three {
    public String Three(String new_id) {
        List<String> possible = new ArrayList<>(Arrays.asList("-", "_", "."));

        int i;

        new_id = new_id.toLowerCase();
        for(i=0; i<new_id.length(); i++){
            int ascii = Character.getNumericValue(new_id.charAt(i));
            if(98 > ascii || ascii> 122){
                if(48 > ascii  ||ascii >57){
                    if(!possible.contains(new_id.charAt(i))){
                        new_id = new_id.replace(Character.toString(new_id.charAt(i)),"");
                    }
                }
            }
        }
        new_id = new_id.replace("..",".");
        if(new_id.startsWith(".")){
            new_id = new_id.substring(1,new_id.length()-1);
        }

        if(Character.compare(new_id.charAt(new_id.length()-1), ".".charAt(0)) == 0){
            new_id = new_id.substring(0,new_id.length()-2);
        }


        return answer;
    }

}
