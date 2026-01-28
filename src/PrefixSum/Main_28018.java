package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_28018 {
	final static int LENGTH = 1000000;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] diff = new int[LENGTH+2];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	diff[Integer.parseInt(st.nextToken())]++;
        	diff[Integer.parseInt(st.nextToken())+1]--;
        }
        
        for(int i = 2; i <= LENGTH; i++) {
        	diff[i] += diff[i-1];
        }
        
        n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	sb.append(diff[Integer.parseInt(st.nextToken())]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}