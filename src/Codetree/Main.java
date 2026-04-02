package Codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        		int input = Integer.parseInt(st.nextToken());
        		if(input % 2 == 1) continue;
        		sb.insert(0, input);
        		sb.insert(0, " ");
        }
        
        System.out.println(sb.toString().trim());
	}
}