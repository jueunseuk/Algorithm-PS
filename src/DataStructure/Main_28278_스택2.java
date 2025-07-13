package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_28278_스택2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(Integer.parseInt(st.nextToken())) {
				case 1 : {
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				}
				case 2 : {
					if(stack.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(stack.pop());
					}
					sb.append("\n");
					break;
				}
				case 3 : {
					sb.append(stack.size());
					sb.append("\n");
					break;
				}
				case 4 : {
					if(stack.isEmpty()) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					sb.append("\n");
					break;
				}
				case 5 : {
					if(stack.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(stack.peek());
					}
					sb.append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}

}
