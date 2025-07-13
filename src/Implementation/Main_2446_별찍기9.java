package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2446_별찍기9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // Upper part
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < (2 * N - 1) - (2 * i); k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // Lower part
        for (int i = 1; i < N; i++) {
            for (int j = N - 1; j > i; j--) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
