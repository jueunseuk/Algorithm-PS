package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1788_피보나치수의확장 {
	static long[] positive = new long[1000001];

	public static void main(String[] args) throws Exception {
		posiFibo();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n > 0) {
			System.out.println(1);
			System.out.println(positive[n]);
		} else if(n < 0) {
			n = -n;
			if(n % 2 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(1);
			}
			System.out.println(positive[n]);
		} else {
			System.out.println(0);
			System.out.println(0);
		}
	}
	
	public static void posiFibo() {
		positive[0] = 0;
		positive[1] = 1;
		
		for(int i = 2; i < 1000001; i++) {
			positive[i] = (positive[i-1]+positive[i-2])%1000000000;
		}
	}

}
