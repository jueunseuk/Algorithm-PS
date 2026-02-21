package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_24416_알고리즘수업_피보나치수1 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int recur = re(n);
        
        System.out.println(recur+" "+(n-2));
	}

	private static int re(int n) {
		if(n == 1 || n == 2) return 1;
		return re(n-1) + re(n-2);
	}
}