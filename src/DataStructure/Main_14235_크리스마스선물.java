package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14235_크리스마스선물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int input = Integer.parseInt(st.nextToken());
			
			if(input == 0) {
				if(q.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(q.poll());
				}
				sb.append("\n");
			} else {
				for(int j = 0; j < input ; j++) {
					q.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}

		System.out.println(sb.toString().trim());
	}
}