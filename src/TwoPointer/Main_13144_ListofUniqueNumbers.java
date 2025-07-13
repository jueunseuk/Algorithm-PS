package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13144_ListofUniqueNumbers {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int []input = new int[n];
		boolean[] exist = new boolean[100001];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		long cnt = 0;
		for(int i = 0; i < n; i++) {
			int current = i;
			
			
			while(current < n) {
				if(!exist[input[current]]) {
					exist[input[current]] = true;
					cnt++;
					current++;
				} else {
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}