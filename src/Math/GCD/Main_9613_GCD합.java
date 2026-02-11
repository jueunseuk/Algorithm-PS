package Math.GCD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9613_GCD합 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int n = Integer.parseInt(st.nextToken());
        	
        	long[] arr = new long[n];
        	for(int i = 0; i < n; i++) {
        		arr[i] = Long.parseLong(st.nextToken());
        	}
        	
        	long gcd = 0;
        	for(int i = 0; i < n; i++) {
        		for(int j = i+1; j < n; j++) {
        			gcd += gcd(arr[i], arr[j]);
        		}
        	}
        	
        	sb.append(gcd).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	static long gcd(long a, long b) {
		while(b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}
