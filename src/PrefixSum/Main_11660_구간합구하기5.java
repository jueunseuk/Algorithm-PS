package PrefixSum;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int T = Integer.parseInt(st1.nextToken());
		
		int[][] arr = new int[N][N];
		
		// 배열 입력
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] sum = new long[N][N];
		
		// 누적합 처음 초기화
		for(int i = 0; i < N; i++) {
			sum[i][0] = arr[i][0];
		}
		
		// 누적합 계산
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				sum[i][j] = sum[i][j-1] + arr[i][j];
			}
		}
		
		// 각 케이스에 대한 계산
		for(int t = 0; t < T; t++) {
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st2.nextToken())-1;
			int y1 = Integer.parseInt(st2.nextToken())-1;
			int x2 = Integer.parseInt(st2.nextToken())-1;
			int y2 = Integer.parseInt(st2.nextToken())-1;
			
			long result = 0;
			
			// 합 계산			
			for(int i = x1; i <= x2; i++) {
				if(y1 == 0) {
					result += sum[i][y2];
				} else {
					result += sum[i][y2] - sum[i][y1-1];					
				}
			}
			
			System.out.println(result);
		}
		
		br.close();
	}
}