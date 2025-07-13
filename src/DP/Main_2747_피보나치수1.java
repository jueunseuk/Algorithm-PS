package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2747_피보나치수1 {
	static long[] fibo = new long[91];

	public static void main(String[] args) throws Exception {
		fibo();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fibo[n]);
	}
	
	public static void fibo() {
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i = 2; i < 91; i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
	}

}
