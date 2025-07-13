package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_15650 { // combination
	
	static int N, M;
	static int[] num, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //depth 와 동일
		num = new int[M];
		ans = new int[M];
		
		combi(0, 1);
	}//main
	
	public static void combi(int depth, int idx) {
		if(depth == M) { //재귀 종료할 조건
			for(int i = 0; i < M; i++) {
				System.out.print(ans[i]);
				if(i < M-1)
				System.out.print(" ");
			}
			System.out.println();
			return;
		}//if
		
		// 반복적인 재귀 호출
		for(int i = idx; i <= N; i++) {
			//선택되지 않았다면 실행
			ans[depth] = i;
			combi(depth+1, i+1);
		}//for
	}//combination
}//class