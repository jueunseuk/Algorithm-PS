package Sweeping;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2170_선긋기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] input = new int[n][2];
		StringTokenizer st;
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int o1[], int o2[]) {
				return o1[0]-o2[0];
			}
		});
		
		int result = 0;
		int start = input[0][0];
		int end = input[0][1];
		
		for(int i = 1; i < n; i++) {
			if(input[i][0] > end) {
				result += end-start;
				start = input[i][0];
				end = input[i][1];
			} else {
				if(input[i][1] > end) {
					end = input[i][1];
				}
			}
			
		}
		
		result += end-start;
		
		System.out.println(result);
	}

}
