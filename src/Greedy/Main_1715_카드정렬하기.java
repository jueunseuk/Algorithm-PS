package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1715_카드정렬하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Long> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n ; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		if(n == 1) {
			System.out.println(0);
			return;
		}
		
		long sum = 0;
		while(pq.size() > 1) {
			long first = pq.poll();
			long last = pq.poll();
			
			pq.add(first+last);
			sum += first+last;
		}
		
		System.out.println(sum);
	}

}
