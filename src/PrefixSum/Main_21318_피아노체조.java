package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21318_피아노체조 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int prev = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n+1];
        for(int i = 0; i < n-1; i++) {
        	int curr = Integer.parseInt(st.nextToken());
        	
        	if(prev > curr) {
        		arr[i+1]++;
        	}
        	
        	prev = curr;
        }
        
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++) {
        	sum[i] += sum[i-1] + arr[i];
        }
        
        StringBuilder sb = new StringBuilder();
        int query = Integer.parseInt(br.readLine());
        for(int q = 0; q < query; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	sb.append(sum[end]-sum[start-1]-arr[end]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}