package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.println(1);
			return;
		}
		
		Deque<Integer> que = new ArrayDeque<>();
		
		for(int i = 1 ; i <= n; i++) {
			que.add(i);
		}
		
		while(que.size()!=1) {
			que.removeFirst();
			que.addLast(que.getFirst());
			que.remove();
		}
		System.out.println(que.poll());
		
	}

}
