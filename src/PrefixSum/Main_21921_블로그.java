package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_21921_블로그 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[n+1];
		sum[1] = arr[1];
		for(int i = 2; i <= n; i++) {
			sum[i] += sum[i-1] + arr[i];
		}
		
		int max = 0;
		int cnt = 0;
		int left = 0;
		int right = k;
		while(right <= n) {
			if(sum[right]-sum[left] > max) {
				max = sum[right]-sum[left];
				cnt = 1;
			} else if(sum[right]-sum[left] == max) {
				cnt++;
			}
			
			left++;
			right++;
		}
		
		if(max == 0) {
			System.out.println("SAD");
			return;
		}
		
		System.out.println(max);
		System.out.println(cnt);
	}
}