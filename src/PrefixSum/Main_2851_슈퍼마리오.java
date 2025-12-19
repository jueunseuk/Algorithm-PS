package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2851_슈퍼마리오 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] input = new int[11];
        for(int i = 1; i <= 10; i++) {
        	input[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 1; i <= 10; i++) {
        	input[i] += input[i-1];
        }
        
        int[] gap = new int[11];
        for(int i = 1; i <= 10; i++) {
        	gap[i] = Math.abs(100-input[i]);
        }
        
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 10; i >= 1; i--) {
        	if(gap[i] < min) {
        		min = gap[i];
        		idx = i;
        	} else break;
        }
        
        System.out.println(input[idx]);
	}
}