package LV2;

import java.util.*;
import java.util.stream.Collectors;

public class Five {
    Set<Integer> primeSet = new HashSet<>();

    public Boolean isPrime(int num){

        if(num <= 1) return Boolean.FALSE;
        int mid = num / 2;
        for(int i =  2; i<mid+1; i++){
            if(num % i == 0) return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public void dfs(List<String> num_list, String part){
        //System.out.println("dfs : " + num_list + " part = " + part);
        if(num_list.size() == 0){
            return ;
        }
        for(String n : num_list){
            if(isPrime(Integer.parseInt(part + n))){
                primeSet.add(Integer.parseInt(part + n));
               // System.out.println("prime");
            }
            List<String> copy_list = new ArrayList<>(num_list);
            copy_list.remove(n);
            dfs(copy_list, part + n);
        }
    }

    public int solution(String numbers) {
        List<String> nums = Arrays.stream(numbers.split("")).collect(Collectors.toList());
        dfs(nums, "");


        return primeSet.size();
    }
}
