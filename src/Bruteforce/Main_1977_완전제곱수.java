package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1977_완전제곱수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[] arr = new int[101];
        for(int i = 1; i <= 100; i++) {
        	arr[i] = i*i;
        }
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= 100; i++) {
        	if(arr[i] >= n && arr[i] <= m) {
        		min = Math.min(min, arr[i]);
        		sum += arr[i];
        	}
        }
        
        if(sum == 0) {
        	System.out.println(-1);
        } else {
        	System.out.println(sum);
        	System.out.println(min);
        }
	}
}