package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294_동전2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int value[] = new int[n];
		for(int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(value);
		
		int dp[] = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		
		
		

	}

}
