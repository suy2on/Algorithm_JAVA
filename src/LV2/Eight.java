package LV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Eight{
    public class Node {

        private Boolean end = false;
        private HashMap<Character, Node> subNode = new HashMap<>();

    }


    public boolean solution(String[] phone_book) {
        Node root = new Node();
        Node p;

        Arrays.sort(phone_book);

        for(String number : phone_book){
            p = root;
            for(int i = 0; i<number.length(); i++){
                Node nNode = new Node();
                if(p.subNode.keySet().contains(number.charAt(i))){
                    if(p.subNode.get(number.charAt(i)).end) return false;
                    p = p.subNode.get(number.charAt(i));
                }
                else{
                    p.subNode.put(number.charAt(i), nNode);
                    p = nNode;
                }
            }
            p.end = Boolean.TRUE;
        }

        return true;
    }
}