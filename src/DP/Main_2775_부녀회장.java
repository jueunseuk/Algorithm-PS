package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2775_부녀회장 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// k 는 0층부터 시작하고, n 은 1호부터 시작
		// 다만 0층은 초기값이기 때문에 사용 x
		
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int [][] info = new int[15][15];
			
			// 기본값인 0층 초기화
			for(int j = 1; j <= 14; j++) info[0][j] = j;
			
			// 1층부터 14층까지 숫자 더해가면서 배열에 저장해보자
			for(int j = 1; j <= 14; j++) {
				int sum = 0;
				for(int ho = 1; ho <= n; ho++) {
					sum += info[j-1][ho];
					info[j][ho] += sum;
				}
			}
			
			System.out.println(info[k][n]);
		}
		
		
	}

}
