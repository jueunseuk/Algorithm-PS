package Bruteforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2502_떡먹는호랑이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[d];
		
		for(int i = 1; i <= k/2; i++) {
			for(int j = i; j < k; j++) {
				dp[0] = i;
				dp[1] = j;
				
				for(int l = 2; l < d; l++) {
					dp[l] = dp[l-1] + dp[l-2];
				}
				
				if(dp[d-1] == k) {
					System.out.println(dp[0]);
					System.out.println(dp[1]);
					return;
				}
			}
		}
	}
}