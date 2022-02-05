package LV1;

import java.util.ArrayList;
import java.util.List;

public class Nine {
    public int[] solution(int[] answers) {
        List<Integer> result = new ArrayList<>();
        int [] one = {1, 2, 3, 4, 5};
        int [] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1, cnt2 , cnt3;
        cnt1 = cnt2 = cnt3 = 0;

        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i%one.length]) cnt1++;
            if(answers[i] == two[i%two.length]) cnt2++;
            if(answers[i] == three[i%three.length]) cnt3++;
        }

        if(cnt1>=cnt2 & cnt1>=cnt3) result.add(1);
        if(cnt2>=cnt1 & cnt2>=cnt3) result.add(2);
        if(cnt3>=cnt2 & cnt3>=cnt1) result.add(3);

        return result.stream().mapToInt(i->i).toArray();
    }
}
