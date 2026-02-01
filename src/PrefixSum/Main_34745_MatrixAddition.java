package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_34745_MatrixAddition {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());
        
        long[][] origin = new long[n][n];
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		origin[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        long[][] diff = new long[n+1][n+1];
        for(int q = 0; q < query; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int sx = Integer.parseInt(st.nextToken())-1;
        	int sy = Integer.parseInt(st.nextToken())-1;
        	int ex = Integer.parseInt(st.nextToken())-1;
        	int ey = Integer.parseInt(st.nextToken())-1;
        	int v = Integer.parseInt(st.nextToken());
        	
        	diff[sx][sy] += v;
        	diff[sx][ey+1] -= v;
        	diff[ex+1][sy] -= v;
        	diff[ex+1][ey+1] += v;
        }
        
        long[][] sum = new long[n+1][n+1];
        sum[0][0] = diff[0][0];
        for(int i = 1; i < n; i++) {
        	sum[i][0] = sum[i-1][0] + diff[i][0];
        	sum[0][i] = sum[0][i-1] + diff[0][i];
        }
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + diff[i][j];
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		sb.append(sum[i][j]+origin[i][j]);
        		if(j < n-1) sb.append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}