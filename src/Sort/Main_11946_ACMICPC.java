package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11946_ACMICPC {
	static class Team {
		
	}
	
	static class Log {
		
	}

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 팀 수
        int m = Integer.parseInt(st.nextToken()); // 문제 수
        int query = Integer.parseInt(st.nextToken()); // 채점 로그 수
        
        for(int q = 0; q < query; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int time = Integer.parseInt(st.nextToken());
        	int team = Integer.parseInt(st.nextToken());
        	int question = Integer.parseInt(st.nextToken());
        	String result = br.readLine();
        	
        	
        	
        	
        }

	}

}
