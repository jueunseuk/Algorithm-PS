package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11055_가장큰증가하는부분수열 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int input[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[n];
		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
            dp[i] = input[i];
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + input[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
		
		System.out.println(max);
	}

}
