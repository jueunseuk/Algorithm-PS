package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1105_팔 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String l = st.nextToken();
        String r = st.nextToken();
        
        int cnt = 0;
        if(l.length() == r.length()) {
        	if(l.equals(r)) {
        		for(int i = 0; i < l.length(); i++) {
        			if(l.charAt(i) == '8') cnt++;
        		}
        		System.out.println(cnt);
        	} else {
        		int fix = 0;
        		for(int i = 0; i < l.length(); i++) {
        			if(l.charAt(i) == r.charAt(i)) {
        				if(l.charAt(i) == '8') cnt++;
        			} else {
        				break;
        			}
        		}
        		System.out.println(cnt);
        	}
        } else {
        	System.out.println(0);
        }
	}
}