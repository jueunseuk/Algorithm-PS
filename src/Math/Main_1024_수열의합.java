package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1024_수열의합 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        int sum[] = new int[101];
        for(int i = 1; i < 101; i++) {
        	sum[i] = sum[i-1] + i;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 0 포함
        if((n-sum[l-1]) % l == 0) {
        	int div = (n-sum[l-1]) / l;
        	
        	if(div < 0) {
        		System.out.println(-1);
        		return;
        	}
        	
        	for(int i = 0; i < l; i++) {
        		sb.append(i+div).append(" ");
        	}
        	
        	System.out.println(sb.toString().trim());
        	return;
        }
        
        // 0 없는 경우
        for(int i = l; i < 101; i++) {
        	if((n-sum[i]) % i == 0) {
        		int div = (n-sum[i]) / i;
        		
        		if(div < 0) {
            		break;
            	}
        		
        		for(int j = 1; j <= i; j++) {
        			sb.append(j+div).append(" ");
        		}
        		
        		System.out.println(sb.toString().trim());
        		return;
        	} else if(n < sum[l]) {
        		break;
        	}
        }
        
        System.out.println(-1);
	}
}