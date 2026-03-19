package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5912_HaybaleStacking {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] diff = new int[n+1];
        
        for(int i = 0; i < k; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		diff[Integer.parseInt(st.nextToken())-1]++;
        		diff[Integer.parseInt(st.nextToken())]--;
        }
        
        for(int i = 1; i < n; i++) {
        		diff[i] += diff[i-1];
        }
        
        Arrays.sort(diff);
        
        System.out.println(diff[n/2+1]);
	}
}