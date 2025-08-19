package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_PrefixSum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 배열의 원소 개수
		int query = Integer.parseInt(st.nextToken()); // 쿼리 개수
		
		int[] origin = new int[n+1]; // 원본 배열
		int[] sum = new int[n+1]; // 누적합 배열
		
		// 원본 배열 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}
		
		// 누적합 배열 계산
		for(int i = 1; i <= n; i++) {
			// 이전 인덱스인 i-1과 현재의 원소인 origin[i]를 더해서 할당
			sum[i] = sum[i-1] + origin[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < query; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(sum[end]-sum[start-1]+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}