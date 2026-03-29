package Codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = n; i <= 100; i++) {
        		if(i >= 90) sb.append("A ");
        		else if(i >= 80) sb.append("B ");
        		else if(i >= 70) sb.append("C ");
        		else if(i >= 60) sb.append("D ");
        		else sb.append("F ");
        }
        
        System.out.println(sb.toString().trim());
	}
}