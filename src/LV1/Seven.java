package LV1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seven {
    public int solution(int[] numbers) {
        int answer = 0;
        IntStream not_exist = IntStream.range(0,10);
        List<Integer> nums = Arrays.stream(numbers).boxed().collect(Collectors.toList());


        not_exist = not_exist.filter(i -> ! nums.contains(i));


        return not_exist.sum();
    }

    public int solution2(int[] numbers) {
        return 45- Arrays.stream(numbers).sum();
    }

}
