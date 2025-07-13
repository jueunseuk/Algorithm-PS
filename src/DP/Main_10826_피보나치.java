package DP;
public class Main_10826_피보나치 {
	static long[] fibo = new long[10000001];
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		long start = System.nanoTime();
		
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i = 2; i < 10000001; i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2]) % MOD;
		}
		
		long end = System.nanoTime();
		
		System.out.println((end-start)/1000000);
	}

}