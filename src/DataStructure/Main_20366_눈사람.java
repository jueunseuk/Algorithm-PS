package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20366_눈사람 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		int minSum = Integer.MAX_VALUE;
		for(int left = 0; left < n; left++) {
			for(int right = n-1; right > left; right--) {
				int sum1 = input[left] + input[right];
				int i = left + 1;
				int j = right - 1;
				
				while(i < j) {
					int sum2 = input[i] + input[j];
					
					minSum = Math.min(minSum, Math.abs(sum2 - sum1));
					
					if(sum1 >= sum2) {
						i++;
					} else {
						j--;
					}
				}
			}
		}
		
		System.out.println(minSum);
	}
}