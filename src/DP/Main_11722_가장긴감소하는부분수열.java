package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int []num = new int[n];
		for(int i = 0 ; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(num[j] > num[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.println(max);
	}

}
