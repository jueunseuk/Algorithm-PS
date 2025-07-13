package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6003_ClaustrophobicCows {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int input[][] = new int[n][2];
        
        long min = Long.MAX_VALUE;
        int x = 0, y = 0;
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	input[i][0] = Integer.parseInt(st.nextToken());
        	input[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < n-1; i++) {
        	for(int j = i+1; j < n; j++) {
        		long calc = calc(input[i][0], input[i][1], input[j][0], input[j][1]);
        		
        		if(calc < min) {
        			min = calc;
        			x = i+1;
        			y = j+1;
        		}
        	}
        }
        
        System.out.println(x+" "+y);

	}
	
	public static long calc(long x1, long y1, long x2, long y2) {
		return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
	}

}
