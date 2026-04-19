package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16713_GenericQueries {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int query = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int[] sum = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i] ^ sum[i-1];
		}
		
		int result = 0;
		for(int q = 0; q < query; q++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			result ^= sum[end] ^ sum[start-1];
		}
		
		System.out.println(result);
	}
}