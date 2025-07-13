package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] origin = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " "	);
		for(int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(origin);
		
		int M = Integer.parseInt(br.readLine());
		int[] target = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i< M ; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		int result[] = new int[M];
		
		for(int i = 0 ; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(target[i]<=origin[j] && target[i]==origin[j]) {
					result[i]++;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			System.out.print(result[i]);
			if(i < M-1) System.out.print(" ");
		}
		
	}

}
