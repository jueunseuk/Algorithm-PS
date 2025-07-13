package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_15651 { // 중복순열, 순열에서 isSelected만 제거
	
	static int N, M;
	static int[] num;
	static int ans[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //depth 와 동일
		num = new int[M];
		ans = new int[M];
		
		perm(0);
		
		System.out.println(sb.toString());
	}//main
	
	public static void perm(int depth) {
		if(depth == M) { //재귀 종료할 조건
            for(int i = 0; i < M; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.setLength(sb.length() - 1); // 마지막 공백 제거
            sb.append('\n');
			return;
		}//if
		
		// 반복적인 재귀 호출
		for(int i = 1; i <= N; i++) {
			//선택되지 않았다면 실행
			ans[depth] = i;
			perm(depth+1);
		}//for
	}//perm
}//class