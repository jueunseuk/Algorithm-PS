package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_10815 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Set<Integer> saw = new HashSet<>();
		for(int i = 0; i < N; i++) {
			saw.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		int memo[] = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < M ; i++) {
			memo[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int memoList : memo) {
			if(saw.contains(memoList)) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			sb.append(" ");
		}
		
		System.out.println(sb.toString().trim());
			
	}

}
