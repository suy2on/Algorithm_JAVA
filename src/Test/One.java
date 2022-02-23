package Test;

import java.util.Arrays;

public class One {
    public int solution(int[] arr) {
        int small, big;
        int past = 10000;
        int now = 0;
        int i = arr.length -1;

        Arrays.sort(arr);

        while(i>=0){
            System.out.println(past);
            System.out.println(now);
            while(i>=0 && arr[i] == arr[i-1]) i--;
            small = i;
            big = arr.length - i;
            System.out.println(small);
            System.out.println(big);
            now = Math.abs(small-big);
            if(past <= now) break;
            past = now;
            i--;
        }


        if(past == now){
            System.out.println("hi");
            return arr[i-1] + 1;
        }

        while(arr[i] < arr[i+1]) i++;

        return arr[i] + 1;

    }
}
