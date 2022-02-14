package LV2;

import java.util.Arrays;

public class Twoleve {
    public int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);

        int head = 0;
        int tail = people.length-1;
        int total = people[tail];

        while(head < tail){
            total = total + people[head];
            if(total < limit){ // 제한 미만
                head++;
            }
            else if(total == limit){ // 딱 제한
                head++;
                count++;
                total = people[++tail];
            }
            else{ // 제한 초과
                count++;
                total = people[++tail];
            }
        }

        if(total != limit){ // 마지막처리
            count++;
        }

        return count;
    }

    public int solution2(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);

        int head = 0;
        int tail = people.length-1;

        while(head < tail){
            if(people[head] + people[tail] <= limit) head++;
            tail--;
            count++;

        }

        if(tail == head) count++;

        return count;
    }
}
