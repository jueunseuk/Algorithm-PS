package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13975_파일합치기3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			Queue<Long> pq = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < n ; i++) {
				pq.add(Long.parseLong(st.nextToken()));
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

}
