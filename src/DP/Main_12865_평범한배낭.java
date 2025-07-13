package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int amount = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        // 0 : 무게, 1 : 가치
        int[][] table = new int[amount + 1][2];

        for (int i = 1; i <= amount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[][] dp = new int[amount + 1][limit + 1];

        for (int i = 1; i <= amount; i++) {
            for (int w = 0; w <= limit; w++) {
                if (table[i][0] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - table[i][0]] + table[i][1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[amount][limit]);
    }
}
