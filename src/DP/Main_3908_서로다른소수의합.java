package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3908_서로다른소수의합 {
	static List<Integer> list = new ArrayList<>();
	static boolean prime[] = new boolean[1121];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        getPrime();
        
        int n = Integer.parseInt(br.readLine());

        int dp[][] = new int[1121][15];
        
        dp[0][0] = 1;
        
        for(int prime : list) {
        	for(int i = 1120; i >= prime; i--) {
        		for(int j = 1; j <= 14; j++) {
        			dp[i][j] += dp[i-prime][j-1];
        		}
        	}
        }
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void getPrime() {
		Arrays.fill(prime, true);
		
		prime[0] = prime[1] = false;
		
		for(int i = 2; i <= Math.sqrt(1120); i++) {
			if(prime[i]) {
				for(int j = i*i; j < 1121; j += i) {
					prime[j] = false;
				}
			}
		}
		
		for(int i = 2; i < 1121; i++) {
			if(prime[i]) {
				list.add(i);
			}
		}
	}
}