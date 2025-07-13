package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_31963_두배 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] logValues = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            logValues[i] = Math.log(value) / Math.log(2);
        }

        long cnt = 0;
        final double EPS = 1e-10;

        for (int i = 1; i < n; i++) {
            if (logValues[i] + EPS < logValues[i - 1]) {
                int k = (int) Math.ceil(logValues[i - 1] - logValues[i] - EPS);
                cnt += k;
                logValues[i] += k;
            }
        }

        System.out.println(cnt);
    }
}
