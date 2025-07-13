package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1927_최소힙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				System.out.println(pq.isEmpty() ? 0 : pq.poll());
				continue;
			}
			
			pq.add(input);
		}
	}

}
