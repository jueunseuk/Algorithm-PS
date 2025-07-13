package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25706_자전거묘기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n];
        dp[n-1] = 1;
        
        for(int i = n-2; i >= 0; i--) {
        	if(input[i] == 0) {
        		dp[i] = dp[i+1]+1;
        	} else {
        		int ni = i+input[i]+1;
        		if(ni >= n) {
        			dp[i] = 1;
        		} else {
        			dp[i] = dp[ni]+1;
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	sb.append(dp[i]+" ");
        }
        
        System.out.println(sb.toString().trim());
	}

}
