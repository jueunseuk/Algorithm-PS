package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_23758_중앙값제거 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int input[] = new int[n];
		for(int i = 0 ; i< n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		long cnt = 0;
		int mid = (n+1)/2;
		for(int i = 0; i < mid; i++) {
			while(input[i] > 1) {
				input[i] /= 2;
				cnt++;
			}
		}
		
		System.out.println(cnt+1);
	}

}
