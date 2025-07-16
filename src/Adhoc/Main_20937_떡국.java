package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20937_떡국 {
	static final int MAX = 50000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[MAX+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		
		int max = 0;
		for(int out : arr) {
			max = Math.max(max, out);
		}
		
		System.out.println(max);
	}

}
