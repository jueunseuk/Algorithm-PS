package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_18258_큐2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String command = st.nextToken();
			
			
			switch(command) {
				case "push" : {
					int number = Integer.parseInt(st.nextToken());
						q.addLast(number);
						break;
				}
				case "pop" : {
					sb.append(q.isEmpty() ? -1 : q.pollFirst()).append("\n");
					break;
				}
				case "size" : {
					sb.append(q.size()).append("\n");
					break;
				}
				case "empty" : {
					sb.append(q.isEmpty() ? 1 : 0).append("\n");
					break;
				}
				case "front" : {
					sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
					break;
				}
				case "back" : {
					sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
					break;				
				}
			}
		}//for
		
		System.out.println(sb);
		br.close();
	}

}
