package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_23832_서로소그래프 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if(n == 1) {
        	System.out.println(0);
        	return;
        }

        int sum = 0;
        for(int k = 2; k <= n; k++) {
        	int origin = k;
        	int result  = k;
	        for(int i = 2; i <= Math.sqrt(origin); i++) {
	        	if(origin % i == 0) {
	        		while(origin % i == 0) {
	        			origin /= i;
	        		}
	        		
	        		result -= result/i;
	        	}
	        }
	        
	        if(origin > 1) {
	        	result -= result/origin;
	        }
	        
	        sum += result;
        }
        
        System.out.println(sum);
	}
}