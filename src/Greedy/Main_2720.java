package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
        	int C = Integer.parseInt(br.readLine());
        	
        	int quar, dime, nick, penn;
        	
        	quar = C/25;
        	C%=25;
        	
        	dime = C/10;
        	C%=10;
        	
        	nick = C/5;
        	C%=5;
        	
        	penn=C;
        	
        	System.out.println(quar+" "+dime+" "+nick+" "+penn);
        }
	}

}
