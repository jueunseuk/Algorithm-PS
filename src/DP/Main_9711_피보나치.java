package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_9711_피보나치 {
	static BigInteger[] fibo = new BigInteger[10001];

	public static void main(String[] args) throws Exception {
		fibo();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int input = Integer.parseInt(st.nextToken());
			String Q = st.nextToken();
			
			System.out.println("Case #"+t+": "+fibo[input].mod(new BigInteger(Q)));
		}
	}
	
	public static void fibo() {
		fibo[0] = new BigInteger("0");
		fibo[1] = new BigInteger("1");
		
		for(int i = 2; i < 10001; i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
	}

}
