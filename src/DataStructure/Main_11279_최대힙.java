package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_11279_최대힙 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
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
