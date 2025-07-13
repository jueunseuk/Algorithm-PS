package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1075_나누기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        n -= n%100;
        
        for(int i = 0; i < 100; i++) {
        	if((n+i) % k == 0) {
        		if(i < 10) {
        			System.out.println("0"+i);
        		} else {
        			System.out.println(i);
        		}
        		return;
        	}
        }

	}

}
