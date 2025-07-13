package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []num = new int[N];
		for(int i = 0 ; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(num[j] < num[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.println(max);
		
	}

}
