package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_28352_10 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long res = 6; 
        for(int i = 11; i <= n; i++) {
        	res *= i;
        }

        System.out.println(res);
	}
}