package LV2;

public class Seven {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int sero, garo = 0;

        for(sero = 2; sero<total; sero++){
            if(total % sero != 0 ) continue;

            garo = total / sero;

            if(brown == sero + garo -4) break;

        }
        return new int[]{sero,garo};
    }
}

