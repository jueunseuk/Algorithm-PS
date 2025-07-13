package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052_카드구매하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int card[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+card[j]);
			}
		}
		
		System.out.println(dp[n]);
	}

}
