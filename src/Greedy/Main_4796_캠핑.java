package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4796_캠핑 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	long l = Integer.parseInt(st.nextToken());
        	long p = Integer.parseInt(st.nextToken());
        	long v = Integer.parseInt(st.nextToken());
        	
        	if(l == 0) {
        		break;
        	}
        	
        	sb.append("Case ").append(cnt++).append(": ").append(l * (v / p) + Math.min(l, v % p)).append("\n");
        }

        System.out.println(sb.toString().trim());
	}
}