package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] input = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		int []sum = new int[N];
		sum[0] = input[0];
		
		for(int i = 1; i < N; i++) {
			sum[i] = input[i]+sum[i-1];
		}
		
		int result = 0;
		
		for(int i = 0 ; i < N; i++) {
			result += sum[i];
		}
		
		System.out.println(result);
		
	}

}
