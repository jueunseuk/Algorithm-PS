package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main_10425_피보나치 {
	static BigInteger[] fibo = new BigInteger[100001];

	public static void main(String[] args) throws Exception {
		fibo();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String input = br.readLine();
			int result = Arrays.binarySearch(fibo, new BigInteger(input));
			
			System.out.println(result);
		}
	}
	
	public static void fibo() {
		fibo[0] = new BigInteger("0");
		fibo[1] = new BigInteger("1");
		
		for(int i = 2; i < 100001; i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
	}

}
