package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_20438_출석체크 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken())+3;
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int query = Integer.parseInt(st.nextToken());
		
		Set<Integer> sleep = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < k; i++) {
			sleep.add(Integer.parseInt(st.nextToken()));
		}
		
		int[] att = new int[n];
		Arrays.fill(att, 1);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < m; i++) {
			int start = Integer.parseInt(st.nextToken());
			
			if(sleep.contains(start)) continue;
			
			int multi = start;
			while(multi < n) {
				if(!sleep.contains(multi)) {
					att[multi] = 0;
				}
				multi += start;
			}
		}
		
		int[] sum = new int[n];
		for(int i = 1; i < n; i++) {
			sum[i] += sum[i-1] + att[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < query; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(sum[end]-sum[start-1]).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}