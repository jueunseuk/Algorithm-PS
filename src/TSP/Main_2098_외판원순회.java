package TSP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098_외판원순회 {
    static final long INF = Long.MAX_VALUE / 4;
    
    static int n;
    static long[][] cost;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        cost = new long[n][n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		int input = Integer.parseInt(st.nextToken());
        		if(i != j && input == 0) cost[i][j] = INF;
        		else cost[i][j] = input;
        	}
        }
        
        System.out.println(TSP(cost));
    }

    public static long TSP(long[][] cost) {
        int N = 1 << n;
        
        long[][] dp = new long[N][n];
        
        for (int m = 0; m < N; m++) {
        	Arrays.fill(dp[m], INF);
        }
        
        dp[1][0] = 0L;

        for (int mask = 1; mask < N; mask++) {
            if ((mask & 1) == 0) continue;

            for (int s = mask; s != 0; s &= (s - 1)) {
                int j = Integer.numberOfTrailingZeros(s);
                long curCost = dp[mask][j];
                if (curCost >= INF) continue;

                int remain = (~mask) & (N - 1);
                for (int t = remain; t != 0; t &= (t - 1)) {
                    int k = Integer.numberOfTrailingZeros(t);
                    long w = cost[j][k];
                    if (w >= INF) continue;

                    long cand;
                    if (curCost > INF - w) cand = INF;
                    else cand = curCost + w;

                    int nmask = mask | (1 << k);
                    if (cand < dp[nmask][k]) dp[nmask][k] = cand;
                }
            }
        }

        int full = N - 1;
        long best = INF;
        for (int j = 1; j < n; j++) {
            long a = dp[full][j];
            long b = cost[j][0];
            if (a >= INF || b >= INF) continue;

            long cand = (a > INF - b) ? INF : a + b;
            if (cand < best) best = cand;
        }

        return best;
    }
}