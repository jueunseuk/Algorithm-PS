package PrefixSum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 수열의 길이
        int M = Integer.parseInt(st.nextToken()); // 목표 합

        int number[] = new int[N];
        int[] prefixSumMod = new int[M];
        long cnt = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = (sum + number[i]) % M;
            if (sum == 0) {
                cnt++;
            }
            prefixSumMod[sum]++;
        }

        for (int i = 0; i < M; i++) {
            if (prefixSumMod[i] > 0) {
                cnt += ((long)prefixSumMod[i] * (prefixSumMod[i] - 1)) / 2;
            }
        }

        System.out.println(cnt);
    }
}
