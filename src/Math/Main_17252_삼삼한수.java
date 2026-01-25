package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17252_삼삼한수 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        if(n == 0) {
        	System.out.println("NO");
        	return;
        }
        
    	for(int i = 19; i >= 0; i--) {
    		int pow = (int) Math.pow(3, i);
    		if(pow <= n) {
    			n -= pow;
    		}
    	}
        
        System.out.println(n == 0 ? "YES" : "NO");
	}
}