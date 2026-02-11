package Math.GCD;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11689_GCD {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        long result = n;
        
        int limit = (int) Math.sqrt(n);
        for(int i = 2; i <= limit; i++) {
        	if(n % i == 0) {
        		while(n % i == 0) {
        			n /= i;
        		}
        		
        		result -= result/i;
        	}
        	
        }
        
        if(n > 1) {
        	System.out.println(n);
        	result -= result/n;
        }
        
        System.out.println(result);
	}
}