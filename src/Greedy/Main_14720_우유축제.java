package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14720_우유축제 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int input[] = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;
        int target = 0;
        for(int out : input) {
        	if(out == target) {
        		cnt++;
        		target++;
        		target %= 3;
        	}
        }
        
        System.out.println(cnt);
	}
}