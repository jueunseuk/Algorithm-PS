package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21758_꿀따기 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int nn = n-1;
        int[] arr = new int[n];
        int[] front = new int[n];
        int[] back = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        front[0] = arr[0];
        for(int i = 1; i < n; i++) {
        	front[i] = front[i-1] + arr[i];
        }
        
        back[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
        	back[i] = back[i+1] + arr[i];
        }
        
        // right
        int max1 = 0;
        for(int i = 1; i < nn; i++) {
        	if(back[1] + back[i+1] - arr[i] > max1) {
        		max1 = back[1] + back[i+1] - arr[i];
        	}
        }
        
        // left
        int max2 = 0;
        for(int i = n-2; i > 0; i--) {
        	if(front[n-2] + front[i-1] - arr[i]> max2) {
        		max2 = front[n-2] + front[i-1] - arr[i];
        	}
        }
        
        // middle
        int idx = 0, max = 0;
        for(int i = 1; i < nn; i++) {
        	if(arr[i] > max) {
        		max = arr[i];
        		idx = i;
        	}
        }
        
        int max3 = front[idx] + back[idx] - arr[0] - arr[nn];
        
        System.out.println(Math.max(Math.max(max1, max2), max3));
	}
}