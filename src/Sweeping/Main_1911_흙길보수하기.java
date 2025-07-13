package Sweeping;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1911_흙길보수하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		
		int [][] input = new int[n][2];
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
		
		int cnt = 0;
		int current = 0;
		for(int i = 0; i < n; i++) {
			if(current <= input[i][0]) {
				current = input[i][0];
			}
			
			while(current < input[i][1]) {
				current += length;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
