package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 위쪽 삼각형
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                sb.append(' ');
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        // 아래쪽 삼각형
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 1; j <= N - i; j++) {
                sb.append(' ');
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
