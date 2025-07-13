package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11525_Farey {

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
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	st.nextToken();
        	sb.append(t+" ").append(arr[Integer.parseInt(st.nextToken())]+1).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}