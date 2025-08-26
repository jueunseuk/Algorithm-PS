package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14465_소가길을건너간이유 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        
        for(int i = 0; i < b; i++) {
        	arr[Integer.parseInt(br.readLine())] = 0;
        }

        int cnt = 0;
        for(int i = 1; i <= k; i++) {
        	cnt += arr[i];
        }
        
        int left = 1;
        int right = k;
        int min = k-cnt;
        while(right < n) {
        	right++;
        	
        	cnt += arr[right];
        	cnt -= arr[left];
        	
        	left++;
        	
    		min = Math.min(min, k-cnt);
        }
        
        System.out.println(min);
	}
}