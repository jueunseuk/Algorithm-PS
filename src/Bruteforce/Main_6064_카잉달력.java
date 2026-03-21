package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6064_카잉달력 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int m = Integer.parseInt(st.nextToken());
        	int n = Integer.parseInt(st.nextToken());
        	int x = Integer.parseInt(st.nextToken())-1;
        	int y = Integer.parseInt(st.nextToken())-1;
        	
        	boolean flag = true;
        	for(int i = x; i < (n*m); i+= m) {
        		if(i % n == y) {
        			sb.append(i+1).append("\n");
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag) {
        		sb.append(-1).append("\n");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}
}