package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1813_논리학교수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] input = new int[51];
		
		for(int i = 0; i < n; i++) {
			input[Integer.parseInt(st.nextToken())]++;
		}
		
		int result = -1;
		for(int i = 50; i >= 0; i--) {
			if(input[i] == i) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
}