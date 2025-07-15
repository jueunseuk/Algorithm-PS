package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_31738_매우어려운문제 {
	static final int MAX = 10_000_000;
	static boolean[] prime = new boolean[MAX+1];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long n = Long.parseLong(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(n >= m) {
			System.out.println(0);
			return;
		}
		
		preprocess();
		
		long res = 1;
        for (long i = 2; i <= n; i++) {
            res *= i;
            res %= m;
            if (res == 0) break;
        }
        
        System.out.println(res);
	}

	private static void preprocess() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		int length = (int) Math.sqrt(MAX);
		for(int i = 2; i <= length; i++) {
			if(prime[i]) {
				for(int j = i*i; j <= MAX; j+= i) {
					prime[j] = false;
				}
			}
		}
	}
}