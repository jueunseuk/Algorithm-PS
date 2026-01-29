package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25826_2차원다중업데이트 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());
        
        long[][] arr = new long[n][n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        long[][] diff = new long[n+1][n+1];
        for(int q = 1; q < query; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	st.nextToken();
        	
        	int sx = Integer.parseInt(st.nextToken());
        	int sy = Integer.parseInt(st.nextToken());
        	int ex = Integer.parseInt(st.nextToken());
        	int ey = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	diff[sx][sy] += k;
        	diff[sx][ey+1] -= k;
        	diff[ex+1][sy] -= k;
        	diff[ex+1][ey+1] += k;
        }

        for(int i = 1; i <= n; i++) {
        	diff[i][0] += diff[i-1][0];
        	diff[0][i] += diff[0][i-1];
        }
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		diff[i][j] += diff[i-1][j] + diff[i][j-1] - diff[i-1][j-1];
        	}
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		arr[i][j] += diff[i][j];
        	}
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        int sx = Integer.parseInt(st.nextToken());
    	int sy = Integer.parseInt(st.nextToken());
    	int ex = Integer.parseInt(st.nextToken());
    	int ey = Integer.parseInt(st.nextToken());
    	
    	long sum = 0;
    	for(int i = sx; i <= ex; i++) {
    		for(int j = sy; j <= ey; j++) {
    			sum += arr[i][j];
    		}
    	}
    	
    	System.out.println(sum);
	}
}