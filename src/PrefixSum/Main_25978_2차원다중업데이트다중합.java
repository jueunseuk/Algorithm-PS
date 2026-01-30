package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25978_2차원다중업데이트다중합 {

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
        int q = 0;
        for(; q < query; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int type = Integer.parseInt(st.nextToken());
        	if(type == 2) break;
        	
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
        
        long[][] sum = new long[n+1][n+1];
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		sum[i][j] += sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i-1][j-1];
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i+q < query; i++) {
        	if(i != 0) {
        		st = new StringTokenizer(br.readLine(), " ");
        		st.nextToken();
        	}
        	
        	int sx = Integer.parseInt(st.nextToken())+1;
        	int sy = Integer.parseInt(st.nextToken())+1;
        	int ex = Integer.parseInt(st.nextToken())+1;
        	int ey = Integer.parseInt(st.nextToken())+1;
        	
        	sb.append(sum[ex][ey]-sum[sx-1][ey]-sum[ex][sy-1]+sum[sx-1][sy-1]).append("\n");
        }
        
    	System.out.println(sb.toString().trim());
	}
}