package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1448_삼각형만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int []input = new int[n];
		
		int maxL = 0;
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		for(int i = n-1; i >= 2; i--) {
			if(input[i] < input[i-1]+input[i-2]) {
				maxL = input[i]+input[i-1]+input[i-2];
			}
			if(maxL != 0) break;
		}
		
		System.out.println(maxL == 0 ? -1 : maxL);
	}

}
