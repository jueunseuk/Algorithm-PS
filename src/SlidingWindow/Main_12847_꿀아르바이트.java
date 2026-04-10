package SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12847_꿀아르바이트 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long curr = 0;
		for(int i = 0; i < m; i++) {
			curr += arr[i];
		}
		
		int left = 0;
		int right = m;
		long max = 0;
		while(right < n) {
			max = Math.max(max, curr);
			
			curr += arr[right++];
			curr -= arr[left++];
		}
		
		System.out.println(max);
	}
}