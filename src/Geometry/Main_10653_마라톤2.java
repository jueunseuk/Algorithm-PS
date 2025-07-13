package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10653_마라톤2 {
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] x = new int[N+1];
        int[] y = new int[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dist = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                dist[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                dist[j][i] = dist[i][j];
            }
        }

        int[][] dp = new int[N+1][K+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[1][0] = 0;

        for(int i = 2; i <= N; i++){
            for(int k = 0; k <= K; k++){
                for(int r = 1; r < i; r++){
                    int s = (i - r - 1);
                    if(s <= k){
                        int prevSkip = k - s;
                        int cand = dp[r][prevSkip] + dist[r][i];
                        if(cand < dp[i][k]){
                            dp[i][k] = cand;
                        }
                    }
                }
            }
        }

        int answer = INF;
        for(int s = 0; s <= K; s++){
            answer = Math.min(answer, dp[N][s]);
        }

        System.out.println(answer);
    }
}
