package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_25184_동가수열구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        if (N % 2 == 0) {
            int m = N / 2;
            for (int i = m; i >= 1; i--) {
                sb.append(i).append(' ');
                sb.append(i + m).append(' ');
            }
        } else {
            int m = N / 2;
            int cur = 1;
            for (int i = 0; i < N; i++) {
                sb.append(cur).append(' ');
                cur += m;
                if (cur > N) cur -= N;
            }
        }

        System.out.println(sb.toString().trim());
    }
}