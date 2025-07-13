package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_4150_피보나치 {
	static BigInteger[] fibo;
	static int n;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		fibo = new BigInteger[n+1];
		fibo();
		
		System.out.println(fibo[n]);
	}
	
	public static void fibo() {
		fibo[0] = new BigInteger("0");
		fibo[1] = new BigInteger("1");
		
		for(int i = 2; i < n+1; i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
	}
}
