package Sweeping;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_19598_최소회의실개수 {

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
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				
				return o1[0]-o2[0];
			}
		});
		
		int cnt = n;
		int room = 0;
		while(cnt > 0) {
			int start = 0;
			int end = 0;
			
		}
	}

}
