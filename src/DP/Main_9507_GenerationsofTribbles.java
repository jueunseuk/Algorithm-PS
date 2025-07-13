package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9507_GenerationsofTribbles {
	static long []dp = new long[68];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ggung();
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb.toString().trim());

	}
	
	public static void ggung() {
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i < 68; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
		}
	}

}
