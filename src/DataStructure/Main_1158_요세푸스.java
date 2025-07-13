package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1158_요세푸스 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i = 1 ; i <= n ; i++) {
			dq.addLast(i);
		}
		
		StringBuilder sb = new StringBuilder("<");
		for(int i = 1; i <= n*k; i++) {
			if(i%k != 0)
			dq.addLast(dq.pollFirst());
			else {
				sb.append(dq.pollFirst()).append(", ");
			}
		}
		
		sb.replace(sb.length()-2, sb.length()-1, ">");
		System.out.println(sb);
		
	}

}
