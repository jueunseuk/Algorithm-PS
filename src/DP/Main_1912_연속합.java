package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []input = new int[N];
		for(int i = 0 ; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		if(input.length == 1) {
			System.out.println(input[0]);
			return;
		}
		
		int reNew = input[0];
		int maxRes = input[0];
		for(int i = 1 ; i < N; i++) {
			reNew = Math.max(input[i], reNew+input[i]);
			maxRes = Math.max(reNew, maxRes);
		}
		
		System.out.println(maxRes);
		
	}

}
