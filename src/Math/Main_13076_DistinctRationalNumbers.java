package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_13076_DistinctRationalNumbers {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int arr[] = new int[10001];
        for(int i = 1; i < 10001; i++) {
        	arr[i] = i;
        }
        
        for(int k = 1; k <= 10000; k++) {
        	int origin = k;
	        for(int i = 2; i <= Math.sqrt(origin); i++) {
	        	if(origin % i == 0) {
	        		while(origin % i == 0) {
	        			origin /= i;
	        		}
	        		
	        		arr[k] -= arr[k]/i;
	        	}
	        }
	        
	        if(origin > 1) {
	        	arr[k] -= arr[k]/origin;
	        }
        }
        
        for(int i = 2; i <= 10000; i++) {
        	arr[i] = arr[i] + arr[i-1];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	sb.append(arr[Integer.parseInt(br.readLine())]+1).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}