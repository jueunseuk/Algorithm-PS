package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_20957_농부비니 {
    static final int MOD = 1000000007;
    
    static final int MAX_N = 10000;
    
    static int[][] sumDP = new int[MAX_N+1][7];
    
    static int[][] noZero7DP = new int[MAX_N+1][7];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        int[] queries = new int[T];
        
        int maxN = 0;
        for(int i = 0; i < T; i++){
            queries[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, queries[i]);
        }
        
        buildDP(maxN);
        
        StringBuilder sb = new StringBuilder();
        for(int n : queries) {
            long totalSumMultiple = sumDP[n][0];
            long noZeroOr7 = noZero7DP[n][0];
            
            long ans = (totalSumMultiple - noZeroOr7) % MOD;
            if(ans < 0) ans += MOD;
            
            sb.append(ans).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    private static void buildDP(int n) {
        for(int digit=1; digit<=9; digit++){
            sumDP[1][digit % 7]++;
        }
        
        for(int digit=1; digit<=9; digit++){
            if(digit == 7) continue;
            noZero7DP[1][digit % 7]++;
        }
        
        for(int length = 2; length <= n; length++){
            int[] nxtSum = new int[7];
            int[] nxtNoZero7 = new int[7];
            
            for(int r=0; r<7; r++){
                int count = sumDP[length-1][r];
                if(count == 0) continue;
                
                for(int digit=0; digit<=9; digit++){
                    int nr = (r + digit) % 7;
                    nxtSum[nr] = (int)((nxtSum[nr] + (long)count) % MOD);
                }
            }
            
            for(int r=0; r<7; r++){
                int count = noZero7DP[length-1][r];
                if(count == 0) continue;
                
                for(int digit=1; digit<=9; digit++){
                    if(digit == 7) continue;
                    int nr = (r + digit) % 7;
                    nxtNoZero7[nr] = (int)((nxtNoZero7[nr] + (long)count) % MOD);
                }
            }
            
            sumDP[length] = nxtSum;
            noZero7DP[length] = nxtNoZero7;
        }
    }
}
