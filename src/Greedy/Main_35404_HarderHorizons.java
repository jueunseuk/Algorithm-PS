package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_35404_HarderHorizons {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
        	int input = Integer.parseInt(st.nextToken());
        	
        	if(max < input) {
        		max = input;
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
	}
}