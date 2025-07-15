package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1402_아무래도이문제는A번난이도인것같다 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
        
		StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
        	br.readLine();
        	sb.append("yes\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}