package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_동전1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int []dp = new int[target+1];
		dp[0] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = arr[i]; j <= target; j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		
		System.out.println(dp[target]);
	}

}
