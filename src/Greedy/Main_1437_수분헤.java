package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1437_수분헤 {
	static int MOD = 10007;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        if(n == 1) {
        	System.out.println(1);
        	return;
        } else if(n == 2) {
        	System.out.println(2);
        	return;
        } else if (n == 3) {
        	System.out.println(3);
        	return;
        } else if (n == 4) {
        	System.out.println(4);
        	return;
        } else if (n == 0) {
        	System.out.println(0);
        	return;
        }
        
        int result = 1;
        if(n % 3 == 0) {
        	for(int i = 0; i < n/3; i++) {
        		result *= 3;
        		result %= MOD;
        	}
        } else if(n % 3 == 1) {
        	for(int i = 0; i < n/3-1; i++) {
        		result *= 3;
        		result %= MOD;
        	}
        	result *= 4;
        	result %= MOD;        	
        } else {
        	for(int i = 0; i <= n/3-1; i++) {
        		result *= 3;
        		result %= MOD;
        	}
        	result *= 2;
        	result %= MOD;
        }
        
        System.out.println(result);
	}

}
