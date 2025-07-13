package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2576_홀수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int input[] = new int[7];
        int sum[] = new int[8];
        
        for(int i = 0; i < 7; i++) {
        	input[i] = Integer.parseInt(br.readLine());
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= 7; i++) {
        	if(input[i-1] % 2 == 0) sum[i] = sum[i-1];
        	else {
        		min = Math.min(min, input[i-1]);
        		sum[i] = sum[i-1] + input[i-1];
        	}
        }
        if(min == 2147483647) {
        	System.out.println(-1);
        } else {
        	System.out.println(sum[7]);
        	System.out.println(min);        	        	
        }
	}

}
