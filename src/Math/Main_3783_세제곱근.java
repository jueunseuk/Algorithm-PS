package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main_3783_세제곱근 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            BigDecimal input = new BigDecimal(br.readLine());
            sb.append(calc(input)).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }

    private static String calc(BigDecimal input) {
        if(input.compareTo(BigDecimal.ZERO) == 0) return "0.0000000000";
        
        int scale = 200;
        BigDecimal two = new BigDecimal("2");
        BigDecimal three = new BigDecimal("3");
        
        int digits = input.precision();
        int exp = (digits - 1) / 3;
        
        BigDecimal guess = BigDecimal.TEN.pow(exp);
        BigDecimal prev = BigDecimal.ZERO;
        BigDecimal thr = BigDecimal.ONE.movePointLeft(150);
        
        while(guess.subtract(prev).abs().compareTo(thr) > 0){
            prev = guess;
            guess = (two.multiply(guess)
                      .add(input.divide(guess.multiply(guess), scale, BigDecimal.ROUND_HALF_UP)))
                     .divide(three, scale, BigDecimal.ROUND_HALF_UP);
        }
        
        guess = guess.setScale(10, BigDecimal.ROUND_DOWN);
        
        return guess.toPlainString();
    }
}
