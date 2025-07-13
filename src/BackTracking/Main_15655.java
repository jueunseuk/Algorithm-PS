package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655 {
	static int N, R;
	static int[] input;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		input = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		result = new int[R];
		
		makeCombi(0, 0);
	}
	
	private static void makeCombi(int depth, int idx) {
		if(depth == R) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < R; i++) {
				sb.append(result[i]);
				if(i < R - 1) sb.append(" ");
			}
			System.out.println(sb.toString());
			return;
		}
		for(int i = idx; i < N; i++) {
			result[depth] = input[i];
			makeCombi(depth+1, i+1);
		}
	}

}
