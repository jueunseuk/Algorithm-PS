package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19951_태상이의훈련소생활 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] h = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	h[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dif = new int[n+1];
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int s = Integer.parseInt(st.nextToken())-1;
        	int e = Integer.parseInt(st.nextToken())-1;
        	int k = Integer.parseInt(st.nextToken());
        	
        	dif[s] += k;
        	dif[e+1] += -k;
        }
        
        for(int i = 1; i <= n; i++) {
        	dif[i] += dif[i-1];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	sb.append(dif[i]+h[i]).append(" ");
        }
        
        System.out.println(sb.toString().trim());
	}
}