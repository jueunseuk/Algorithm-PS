package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15903_카드합체놀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		
		Queue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i = 0; i < cnt; i++) {
			long first = pq.poll();
			long second = pq.poll();
			
			pq.add(first+second);
			pq.add(first+second);
		}
		
		long sum = 0;
		for(Long out : pq) {
			sum += out;
		}
		
		System.out.println(sum);
	}

}
