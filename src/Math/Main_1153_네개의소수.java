package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1153_네개의소수 {
    static final int MAX = 5000000;
    static boolean[] prime = new boolean[MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        getSPF();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        if(n < 8) {
        	System.out.println(-1);
        	return;
        }
        
        if(n % 2 == 0) {
        	sb.append(2+" "+2).append(" ");
        	n -= 4;
        } else {
        	sb.append(2+" "+3).append(" ");
        	n -= 5;
        }
        
        for(int i = 2; i <= MAX; i++) {
        	if(prime[i]) {
	        	for(int j = 2; j <= MAX; j++) {
	        		if(prime[j]) {
	        			if(i + j == n) {
	        				sb.append(i+" "+j);
	        				System.out.println(sb.toString().trim());
	        				return;
	        			}
	        		}
	        	}
        	}
        }
        
    }

    private static void getSPF() {
    	Arrays.fill(prime, true);
    	
    	prime[0] = prime[1] = false;
    	
    	for(int i = 2; i < Math.sqrt(MAX); i++) {
    		if(prime[i]) {
    			for(int j = i*i; j <= MAX; j += i) {
    				prime[j] = false;
    			}
    		}
    	}
    }
}
