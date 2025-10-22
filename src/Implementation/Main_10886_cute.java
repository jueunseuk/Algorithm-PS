package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10886_cute {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
        	cnt += Integer.parseInt(br.readLine());
        }
        
        n /= 2;
        
        System.out.println(n < cnt ? "Junhee is cute!" : "Junhee is not cute!");
	}
}