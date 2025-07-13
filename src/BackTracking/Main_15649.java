package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_15649 { // 순열
	
	static int N, M;
	static boolean[] isSelected;
	static int[] num;
	static int ans[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //depth 와 동일
		num = new int[M];
		ans = new int[M];
		isSelected = new boolean[N+1];
		
		perm(0);
	}//main
	
	public static void perm(int depth) {
		if(depth == M) { //재귀 종료할 조건
			StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                sb.append(ans[i]).append(' ');
            }
            // 마지막 공백을 제거하고 출력
            System.out.println(sb.toString().trim());
			return;
		}//if
		
		// 반복적인 재귀 호출
		for(int i = 1; i <= N; i++) {
			if(isSelected[i]) continue; // 선택되었다면 패스
			//선택되지 않았다면 실행
			isSelected[i] = true;
			ans[depth] = i;
			perm(depth+1);
			isSelected[i] = false;
		}//for
	}//perm
}//class