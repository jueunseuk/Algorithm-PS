package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16510_PredictableQueue {
	static int[] arr;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        		arr[i] += arr[i-1];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int q = 0; q < query; q++) {
        		sb.append(getIndex(Integer.parseInt(br.readLine()), 1, n)-1).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
	
	private static int getIndex(int time, int left, int right) {
		if(left > right) return left;
		
		int mid = (right + left) / 2;
		
		if(time >= arr[mid]) {
			return getIndex(time, mid+1, right);
		} else {
			return getIndex(time, left, mid-1);
		}
	}
}