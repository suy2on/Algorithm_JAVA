package LV1;

public class Four {
    public int Four(String s) {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alpha = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int i;

        for(i=0; i<10; i++){
            s = s.replaceAll(alpha[i],digits[i]);
        }

        return Integer.parseInt(s);
    }
}
