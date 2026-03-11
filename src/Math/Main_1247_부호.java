package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_1247_부호 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < 3; i++) {
        		int n = Integer.parseInt(br.readLine());
        		
        		BigInteger bi = BigInteger.valueOf(0);
        		for(int j = 0; j < n; j++) {
        			bi = bi.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
        		}
        		
        		if(bi.equals(BigInteger.ZERO)) {
    				System.out.println(0);
    			}
    			else if(bi.compareTo(BigInteger.ZERO) > 0) {
    				System.out.println("+");
    			}	
    			else if(bi.compareTo(BigInteger.ZERO) < 0) {
    				System.out.println("-");
    			}	
        }
	}
}