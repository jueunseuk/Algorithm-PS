package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2877_4와7 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine())+1;
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 1) {
        	if(n % 2 == 0) {
        		sb.append("4");
        	} else {
        		sb.append("7");
        	}
        	n /= 2;
        }
        
        System.out.println(sb.reverse().toString());
	}

}
