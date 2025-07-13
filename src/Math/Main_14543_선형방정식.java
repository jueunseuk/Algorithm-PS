package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main_14543_선형방정식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String input[] = br.readLine().split("[^\\d]+");

            BigDecimal a = new BigDecimal(input[0]);
            BigDecimal b = new BigDecimal(input[1]);
            BigDecimal c = new BigDecimal(input[2]);

            sb.append("Equation ").append(t + 1).append("\n");

            if (a.compareTo(BigDecimal.ZERO) == 0) {
                if (b.compareTo(c) == 0) {
                    sb.append("More than one solution.");
                } else {
                    sb.append("No solution.");
                }
            } else {
                BigDecimal rawResult = c.subtract(b).divide(a, 20, RoundingMode.DOWN);
                BigDecimal truncated = rawResult.setScale(6, RoundingMode.DOWN);

                if (truncated.compareTo(BigDecimal.ZERO) == 0) {
                    sb.append("x = 0.000000");
                } else {
                    sb.append("x = ").append(truncated.toPlainString());
                }
            }
            sb.append("\n\n");
        }

        System.out.println(sb.toString().trim());
    }
}
