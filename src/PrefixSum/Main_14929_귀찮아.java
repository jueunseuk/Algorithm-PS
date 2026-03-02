package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14929_귀찮아 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        long total = 0;
        long result = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	total += arr[i];
        }
        
        for(int i = 0; i < n-1; i++) {
        	total -= arr[i];
        	result += total * arr[i];
        }
        
        System.out.println(result);
	}
}