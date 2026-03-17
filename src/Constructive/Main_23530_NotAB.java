package Constructive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23530_NotAB {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int sum = (Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+1)%50;
        		if(sum == 0) sum += 1;
        		sb.append(sum).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}
